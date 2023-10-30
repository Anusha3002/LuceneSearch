package org.pabay.search.indexhunt.lucene.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Builder
public class TempModel {
    private String id;
    private String description;
}
