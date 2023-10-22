package org.pabay.search.indexhunt.lucene.service.impl;

import org.pabay.search.indexhunt.lucene.entity.Index;
import org.pabay.search.indexhunt.lucene.model.IndexDto;
import org.pabay.search.indexhunt.lucene.repository.IndexRepository;
import org.pabay.search.indexhunt.lucene.service.IndexService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DBIndexServiceImpl implements IndexService {

    final IndexRepository indexRepository;

    public DBIndexServiceImpl(IndexRepository indexRepository) {
        this.indexRepository = indexRepository;
    }

    @Override
    public IndexDto create(IndexDto indexDto) {
        Index index = createFromDto(indexDto);
        index = indexRepository.save(index);
        indexDto.setId(index.getId());
        return indexDto;
    }

    private Index createFromDto(IndexDto indexDto) {
        Index index = new Index();
        index.setId(indexDto.getId());
        index.setName(indexDto.getName());
        index.setPath(indexDto.getPath());
        return index;
    }

    @Override
    public IndexDto update(IndexDto indexDto) {
        return null;
    }

    @Override
    public void delete(String id) {

    }

    @Override
    public IndexDto get(String id) {
        Optional<Index> indexOptional = indexRepository.findById(id);
        if (indexOptional.isPresent()) {
            Index index = indexOptional.get();
            IndexDto dto = createFromEntity(index);
            return dto;
        }
        throw new IllegalArgumentException(" Bad request ");
    }

    private IndexDto createFromEntity(Index index) {
        IndexDto indexDto = new IndexDto();
        indexDto.setId(index.getId());
        indexDto.setName(index.getName());
        indexDto.setPath(index.getPath());
        return indexDto;
    }

    @Override
    public List<IndexDto> getAll() {
        return null;
    }
}
