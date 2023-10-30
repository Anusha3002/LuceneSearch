package com.lucenesearch.searcher;

import com.lucenesearch.model.Product;
import com.lucenesearch.util.LuceneDocumentUtil;
import org.apache.lucene.queryparser.classic.ParseException;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;

import static com.lucenesearch.config.Constants.INDEX_DIR;

public class TestSearch {

    public static void main(String args[]) {

        String indexDir = INDEX_DIR;

        Searcher s = new Searcher(indexDir);

        try {
            System.out.println(URLDecoder.decode("Reference&32; &#35;18&#46;9bf8dal7&#46;1697554334&# 46;171480b0"));
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
