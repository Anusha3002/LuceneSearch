package org.pabay.search.indexhunt.lucene.cli;

import org.pabay.search.indexhunt.lucene.model.IndexDto;
import org.pabay.search.indexhunt.lucene.service.IndexService;
import org.pabay.search.indexhunt.lucene.service.ServiceFactory;

public class IndexesClient {

    public static void main(String agrs[]) {


        //   What is in the coming request
        IndexDto dto = new IndexDto();
        dto.setName("Test");
        dto.setPath("test");
        IndexService indexService = ServiceFactory.createIndexService();
        indexService.create(dto);
        // What is going table
    }
}
