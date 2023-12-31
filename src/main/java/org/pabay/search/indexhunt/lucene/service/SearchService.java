package org.pabay.search.indexhunt.lucene.service;


import com.lucenesearch.model.Product;
import com.lucenesearch.searcher.Searcher;
import com.lucenesearch.searcher.SearcherResult;
import com.lucenesearch.util.LuceneDocumentUtil;
import org.apache.lucene.queryparser.classic.ParseException;
import org.pabay.search.indexhunt.lucene.model.IndexDto;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.lucenesearch.config.Constants.INDEX_DIR;

@Service
public class SearchService {

    final IndexService indexService;

    public SearchService(IndexService indexService) {
        this.indexService = indexService;
    }


    public List<String> search(String indexId, String query) {

        try {
            IndexDto indexDto = indexService.get(indexId);

            System.out.println(indexDto);
            String indexDir = INDEX_DIR + "/"+indexDto.getPath();

            Searcher s = new Searcher(indexDir);
            // get the searched document
            SearcherResult result = s.search(query);
            List<String> results = new ArrayList<>();
            // how many result
            System.out.println(" Total document "+result.getTotalHits());

            // convert back document to product
            List<Product> products = LuceneDocumentUtil.convertDocumentsToProducts(result.getMatchingProducts());

            // print the result
            products.forEach((k) -> {
                results.add(k.getName());
            });

        return results;

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }
}
