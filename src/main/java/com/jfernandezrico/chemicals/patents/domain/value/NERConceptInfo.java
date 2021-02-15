package com.jfernandezrico.chemicals.patents.domain.value;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data @Builder public class NERConceptInfo {

    private String cui;
    private String preferredName;
    private Set<String> sourceSet;
    private Set<String> semanticTypeSet;

}
