package com.jfernandezrico.chemicals.patents.adapter.out.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data @Builder public class NERClassificationMongoDto {
    private Set<String> persons;
    private Set<String> organizations;
    private Set<String> locations;
}
