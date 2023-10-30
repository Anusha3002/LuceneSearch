package org.pabay.search.indexhunt.lucene.service.impl;

import org.pabay.search.indexhunt.lucene.entity.Index;
import org.pabay.search.indexhunt.lucene.model.IndexDto;
import org.pabay.search.indexhunt.lucene.repository.IndexRepository;
import org.pabay.search.indexhunt.lucene.service.IndexService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        index.setAutoCompleteLocation(indexDto.getAutocompleteLocation());
        return index;
    }

    @Override
    public IndexDto update(IndexDto indexDto) {

        if (indexDto == null || indexDto.getId() == null) {
            throw new IllegalArgumentException(" Bad request ");
        }
        Optional<Index> indexOptional = indexRepository.findById(indexDto.getId());
        if (indexOptional.isEmpty()) {
            throw new IllegalArgumentException(" Bad request ");
        }
        Index index = createFromDto(indexDto);
        index = indexRepository.save(index);
        indexDto.setId(index.getId());
        return indexDto;
    }

    @Override
    public void delete(String id) {
        Optional<Index> indexOptional = indexRepository.findById(id);
        if (indexOptional.isEmpty()) {
            throw new IllegalArgumentException(" Bad request ");
        }

        indexRepository.delete(indexOptional.get());

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
        indexDto.setAutocompleteLocation(index.getAutoCompleteLocation());
        return indexDto;
    }

    @Override
    public List<IndexDto> getAll(Pageable pageable, String q) {
        Page<Index> allIndexes = indexRepository.findAll(pageable);
        List<IndexDto> allIndexList = new ArrayList<>();
        for (Index index: allIndexes.getContent()) {
            IndexDto dto = createFromEntity(index);
            allIndexList.add(dto);
        }

        return allIndexList;
    }
}
