package org.pabay.search.indexhunt.lucene.service;


import jakarta.annotation.PostConstruct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.bg.BulgarianAnalyzer;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StoredField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.spell.LuceneDictionary;
import org.apache.lucene.search.suggest.Lookup;
import org.apache.lucene.search.suggest.analyzing.AnalyzingSuggester;
import org.apache.lucene.store.ByteBuffersDirectory;
import org.apache.lucene.store.Directory;
import org.pabay.search.indexhunt.lucene.analyser.AutocompleteAnalyzer;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.pabay.search.indexhunt.lucene.model.TempModel;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutoCompleteService {
    private static final String ID = "id";
    private static final String DESCRIPTION = "description";

    private IndexSearcher dirSearcher;
    private AnalyzingSuggester analyzingSuggester;

    @PostConstruct
    public void initialize() throws IOException {
        // Index that is using stopwords and stems for better search functionality
        ByteBuffersDirectory directory = new ByteBuffersDirectory();

        // Second index is created for the autocomplete functionality.
        // The autocomplete analyzer needs to be simple so the suggestions are as they are in the text.
        Analyzer autocompleteAnalyzer = new AutocompleteAnalyzer();

        ByteBuffersDirectory autocompleteDirectory = new ByteBuffersDirectory();

        try (IndexWriter directoryWriter = new IndexWriter(directory, new IndexWriterConfig(new SimpleAnalyzer()));
             IndexWriter autocompleteDirectoryWriter = new IndexWriter(autocompleteDirectory,
                     new IndexWriterConfig(autocompleteAnalyzer))) {

            // Reading the input data from the csv
            InputStream icdStream = AutoCompleteService.class.getResourceAsStream("/test.csv");
            Reader icdReader = new InputStreamReader(icdStream);
            CSVParser icdParser = new CSVParser(icdReader, CSVFormat.RFC4180);
            for (CSVRecord line : icdParser) {
                Document doc = new Document();
                doc.add(new StoredField(ID, line.get(0)));
                doc.add(new TextField(DESCRIPTION, line.get(1), Field.Store.YES));
                directoryWriter.addDocument(doc);

                Document autocompleteDoc = new Document();
                autocompleteDoc.add(new TextField(DESCRIPTION, line.get(1), Field.Store.YES));
                autocompleteDirectoryWriter.addDocument(autocompleteDoc);
            }
        }

        // Using Lucene's suggester for the autocomplete functionality
        buildAnalyzingSuggester(autocompleteDirectory, autocompleteAnalyzer);

        DirectoryReader indexReader = DirectoryReader.open(directory);
        dirSearcher = new IndexSearcher(indexReader);
    }

    public List<TempModel> search(String keyword) throws ParseException, IOException {
        QueryParser parser = new QueryParser(DESCRIPTION, new BulgarianAnalyzer());
        Query query = parser.parse(keyword);
        TopDocs topDocs = dirSearcher.search(query, 10);
        List<TempModel> icdEntities = new ArrayList<>();
        for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
        Document document = dirSearcher.doc(scoreDoc.doc);
        TempModel tempModel =TempModel.builder()
                .id(document.get(ID))
                .description(document.get(DESCRIPTION))
                .build();
        icdEntities.add(tempModel);
        }

        return icdEntities;
    }

    public List<String> suggestTermsFor(String term) throws IOException {
        List<Lookup.LookupResult> lookup = analyzingSuggester.lookup(term, false, 5);
        List<String> suggestions = lookup.stream().map(a -> a.key.toString()).collect(Collectors.toList());
        return suggestions;
    }

    public void buildAnalyzingSuggester(Directory autocompleteDirectory, Analyzer autocompleteAnalyzer)
            throws IOException {
        DirectoryReader sourceReader = DirectoryReader.open(autocompleteDirectory);
        LuceneDictionary dict = new LuceneDictionary(sourceReader, DESCRIPTION);
        analyzingSuggester = new AnalyzingSuggester(autocompleteDirectory, "autocomplete_temp",
                autocompleteAnalyzer);
        analyzingSuggester.build(dict);
    }
}



