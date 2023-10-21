package com.lucenesearch.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lucenesearch.model.Product;
import org.apache.lucene.document.*;
import org.apache.lucene.util.BytesRef;

import java.util.ArrayList;
import java.util.List;

public class LuceneDocumentUtil {

    public static Document buildDoc(Product product) {
        Document document = new Document();
        document.add(new StringField("id", String.valueOf(product.getId()), Field.Store.YES));
        document.add(new SortedDocValuesField("id", new BytesRef(String.valueOf(product.getId()))));
        document.add(new TextField("name", product.getName(), Field.Store.YES));
        if (product.getDescription() != null)
        document.add(new TextField("description", product.getDescription(), Field.Store.YES));
        document.add(new DoubleField("price", product.getRate(), Field.Store.YES));
        Double doubleValue = product.getRate() > 0 ? product.getRate() : 0;
        document.add(new SortedNumericDocValuesField("price", doubleValue.longValue()));

        // add default field
        StringBuilder builder = new StringBuilder();
        builder.append(product.getId()).append(" ");
        builder.append(product.getName()).append(" ");
        builder.append(product.getRate()).append(" ");
        if (product.getDescription() != null)
        builder.append(product.getDescription()).append(" ");

        document.add(new TextField("defaultField", builder.toString(), Field.Store.NO));

        return document;

    }

    public static Product buildProduct(Document document) {
        Product product = new Product();
        product.setId(Long.parseLong(document.get("id")));
        product.setName(document.get("name"));
        product.setRate(Double.parseDouble(document.get("price")));

        return product;

    }

    public static List<Product> convertDocumentsToProducts(List<Document> documents) {
        List<Product> products = new ArrayList<>();

        for (Document document: documents) {
            System.out.println(document);
            Product product = buildProduct(document);

            products.add(product);
        }

        return products;
    }

    public static List<Document> convertProductsToDocuments(List<Product> products) {
        List<Document> documents = new ArrayList<>();

        for (Product product: products) {
            Document d = buildDoc(product);
            documents.add(d);
        }

        return documents;
    }

    public  static List<Product> convertJsonToProduct(String response) {

        List<Product> products = new Gson().fromJson(response, new TypeToken<ArrayList<Product>>() {
        }.getType());

        return products;
    }
}
