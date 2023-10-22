package com.lucenesearch.indexer;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.lucenesearch.client.http.HttpService;
import com.lucenesearch.indexer.Indexer;
import com.lucenesearch.model.Product;
import com.lucenesearch.model.Products;
import com.lucenesearch.util.LuceneDocumentUtil;
import org.apache.lucene.document.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lucenesearch.config.Constants.INDEX_DIR;

public class TestService {

    public static void main(String args[]) {

        HttpService httpService = new HttpService();

        try {
            String indexDir = INDEX_DIR;
            String res = httpService.get("https://pbapps.in/api/v2/sales/parts");
            //System.out.println(res);

            // convert str response to json and list of products
            List<Product> productList = LuceneDocumentUtil.convertJsonToProduct(res);

            // convert all the products to documents
            List<Document> documents = LuceneDocumentUtil.convertProductsToDocuments(productList);

            // to index , send all the documents to indexer

            Indexer indexer = new Indexer(indexDir);

            indexer.index(documents);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
