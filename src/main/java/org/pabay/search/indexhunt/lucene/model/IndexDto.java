package org.pabay.search.indexhunt.lucene.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class IndexDto {
    private String id;
    private String name;
    private String path;
}