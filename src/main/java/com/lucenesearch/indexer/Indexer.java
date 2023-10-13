package com.lucenesearch.indexer;

import com.lucenesearch.model.Product;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.*;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.List;

public class Indexer {

    private String indexPath;
    // takes an indexPath parameter, which specifies the path where the Lucene index will be stored.

    public Indexer(String indexPath) {
        this.indexPath = indexPath;
    }

    public void indexProducts(List<Product> products) throws IOException {
        Directory indexDirectory = FSDirectory.open(FileSystems.getDefault().getPath(indexPath));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());

        try (IndexWriter writer = new IndexWriter(indexDirectory, config)) {
            for (Product product : products) {
                Document document = new Document();
                document.add(new StringField("id", String.valueOf(product.getId()), Field.Store.YES));
                document.add(new TextField("name", product.getName(), Field.Store.YES));
                document.add(new TextField("description", product.getDescription(), Field.Store.YES));
                // Index other fields as needed
                // Add the document to the index
                writer.addDocument(document);
            }
        }
    }

    public void index(List<Document> documents) throws IOException {
        Directory indexDirectory = FSDirectory.open(FileSystems.getDefault().getPath(indexPath));
        IndexWriterConfig config = new IndexWriterConfig(new StandardAnalyzer());

        try (IndexWriter writer = new IndexWriter(indexDirectory, config)) {
            for (Document doc : documents) {
                writer.addDocument(doc);
            }
        }
    }
}

