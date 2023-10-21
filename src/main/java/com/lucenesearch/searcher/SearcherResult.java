package com.lucenesearch.searcher;

import org.apache.lucene.document.Document;

import java.util.List;

public class SearcherResult {
    private long totalHits;

    private List<Document> matchingProducts;

    public SearcherResult(long totalHits, List<Document> matchingProducts) {
        this.totalHits = totalHits;
        this.matchingProducts = matchingProducts;
    }

    public long getTotalHits() {
        return totalHits;
    }

    public List<Document> getMatchingProducts() {
        return matchingProducts;
    }
}
