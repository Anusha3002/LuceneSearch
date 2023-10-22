package org.pabay.search.indexhunt.lucene.controller;


import org.pabay.search.indexhunt.lucene.model.IndexDto;
import org.pabay.search.indexhunt.lucene.service.IndexService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class IndexController {


    final IndexService indexService;

    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @PostMapping("/indexes")
    public ResponseEntity<IndexDto> create(@RequestBody IndexDto indexDto) {
        System.out.println(indexDto);
        return new ResponseEntity<IndexDto>(indexService.create(indexDto), HttpStatus.CREATED);
    }

    @GetMapping("/indexes/{id}")
    public IndexDto get(@PathVariable String id) {
        return indexService.get(id);
    }
}
