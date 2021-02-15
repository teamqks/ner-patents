package com.jfernandezrico.chemicals.patents.adapter.out.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class NERConceptInfoMongoDto {

    private String cui;
    private String preferredName;
    private Set<String> sourceSet;
    private Set<String> semanticTypeSet;

}
