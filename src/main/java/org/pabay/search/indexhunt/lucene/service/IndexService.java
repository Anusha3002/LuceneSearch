package org.pabay.search.indexhunt.lucene.service;


import org.hibernate.annotations.NotFound;
import org.pabay.search.indexhunt.lucene.exception.NotFundException;
import org.pabay.search.indexhunt.lucene.model.IndexDto;

import java.util.List;

/**
 * this service is an interface between Repository and Controller
 */
public interface IndexService {

    public IndexDto create(IndexDto indexDto);

    public IndexDto update(IndexDto indexDto) ;

    public void delete(String id) ;

    public IndexDto get(String id);

    public List<IndexDto> getAll();
}
