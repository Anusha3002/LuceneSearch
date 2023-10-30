package org.pabay.search.indexhunt.lucene.controller;


import org.pabay.search.indexhunt.lucene.model.IndexDto;
import org.pabay.search.indexhunt.lucene.service.IndexService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * Really speaking.. this response should be like below
     * {
     * "hasMore" : true,
     * "pageSize" : 15,
     * "pageNo" : 1,
     * "totalItems"  :300,
     * "items" : []
     * }
     * @param pageNo
     * @param pageSize
     * @param sortBy
     * @param orderBy
     * @param query
     * @return
     */

    @GetMapping("/indexes")
    public ResponseEntity<List<IndexDto>> getAll(
            @RequestParam(name="pageNo", defaultValue = "0") Integer pageNo,
            @RequestParam(name="pageSize", defaultValue = "15") Integer pageSize,
            @RequestParam(name="sortBy", defaultValue = "id") String sortBy,
            @RequestParam(name="order", defaultValue = "desc") String orderBy,
            @RequestParam(name="q", required = false) String query
            ) {

        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.fromString(orderBy),sortBy));
        List<IndexDto> indexes = indexService.getAll(pageable, query);
        return new ResponseEntity<>(indexes, HttpStatus.OK);
    }

    @PutMapping("/indexes/{id}")
    public ResponseEntity<IndexDto> update(@PathVariable String id, @RequestBody IndexDto indexDto) {
        IndexDto updatedIndexDto = indexService.update(indexDto);
        return new ResponseEntity<>(updatedIndexDto, HttpStatus.OK);
        //return new ResponseEntity<>(indexService.update(indexDto), HttpStatus.OK);
    }

    @DeleteMapping("/indexes/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
            indexService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }
}
