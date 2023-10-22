package org.pabay.search.indexhunt.lucene.repository;

import org.pabay.search.indexhunt.lucene.entity.Index;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IndexRepository extends JpaRepository<Index,String> {

}
