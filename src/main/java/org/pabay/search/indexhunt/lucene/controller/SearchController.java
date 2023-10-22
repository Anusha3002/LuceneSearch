package org.pabay.search.indexhunt.lucene.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.pabay.search.indexhunt.lucene.service.SearchService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/indexes")
public class SearchController {

    private final SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

    // GET /api/v1/indexes/{id}/search
    @GetMapping("/{id}/search" )
    public List<String> search(
            @PathVariable("id") String indexDir,
            @RequestParam(value = "q",required = true) String query,
            HttpServletRequest request) {

        List<String> results = searchService.search(indexDir, query);

        return results;
    }
}
