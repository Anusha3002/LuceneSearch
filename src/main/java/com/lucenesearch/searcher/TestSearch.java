package com.lucenesearch.searcher;

import com.lucenesearch.model.Product;
import com.lucenesearch.util.LuceneDocumentUtil;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.util.List;

public class TestSearch {

    public static void main(String args[]) {

        String indexDir = "/Users/anusha/lucene";

        Searcher s = new Searcher(indexDir);

        try {
            // get the searched document
            SearcherResult result = s.search("a*");

            // how many result
            System.out.println(" Total document "+result.getTotalHits());

            // convert back document to product
            List<Product> products = LuceneDocumentUtil.convertDocumentsToProducts(result.getMatchingProducts());

            // print the result
            products.forEach((k) -> {
                System.out.println(k.getId());
            });



        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
