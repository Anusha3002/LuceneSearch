package com.lucenesearch.searcher;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.*;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Searcher {

    private String indexDir;
    public Searcher(String indexDir) {
        this.indexDir = indexDir;
    }

    public SearcherResult search(String title) throws IOException, ParseException {
        List<Document> matchingProducts = new ArrayList<>();
        //We need to open an IndexReader to read the lucene index stored at given indexPath
        IndexReader indexReader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDir)));
        //IndexSearcher will help us query the index
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        //We will use standard analyzer while we parse our query.
        Analyzer analyzer = new StandardAnalyzer();
        //This query parser will search in title field by default if no field is specified.
        //Also, this will use our Standard analyzer to create terms for the query.
        QueryParser queryParser = new QueryParser("defaultField", analyzer);
        //We pass in the title as it is to the query parser.
        // This will create a term query for us on the terms in our title.
        Query query = queryParser.parse(title);


        //We perform the search and get top 10 search results.
        TopDocs topDocs = indexSearcher.search(query, 10);
        //Print the count of matching documents.
        long totalHits = topDocs.totalHits.value;
        System.out.println(String.format("Found %d hits.", totalHits));

        //Print the title field of each matching products
        ScoreDoc[] results  = topDocs.scoreDocs;

        for(ScoreDoc scoreDoc: results){
            //Returns the id of the document matching the query
            int docId = scoreDoc.doc;
            //float score = scoreDoc.score;
            //We fetch the complete document from index via its id
            Document product = indexSearcher.doc(docId);
            matchingProducts.add(product);
            //We fetch the complete document from index via its name
            //...
           // System.out.println(String.format("Found: %s", product));
        }

        return new SearcherResult(totalHits, matchingProducts);
    }

    public SearcherResult search(Query query, int numberOfDocumentsInOut, Sort sort) throws IOException, ParseException {
        List<Document> matchingProducts = new ArrayList<>();
        //We need to open an IndexReader to read the lucene index stored at given indexPath
        IndexReader indexReader = DirectoryReader.open(FSDirectory.open(Paths.get(indexDir)));
        //IndexSearcher will help us query the index
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);

        //We perform the search and get top 10 search results.
        TopDocs topDocs = indexSearcher.search(query, numberOfDocumentsInOut, sort);
        //Print the count of matching documents.
        long totalHits = topDocs.totalHits.value;
        System.out.println(String.format("Found %d hits.", totalHits));

        //Print the title field of each matching products
        ScoreDoc[] results  = topDocs.scoreDocs;

        for(ScoreDoc scoreDoc: results){
            //Returns the id of the document matching the query
            int docId = scoreDoc.doc;
            //float score = scoreDoc.score;
            //We fetch the complete document from index via its id
            Document product = indexSearcher.doc(docId);
            matchingProducts.add(product);
            //We fetch the complete document from index via its name
            //...
            // System.out.println(String.format("Found: %s", product));
        }

        return new SearcherResult(totalHits, matchingProducts);
    }
}
