package com.jfernandezrico.chemicals.patents.adapter.out.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MetadataMongoDto {
    private String application;
    private Integer year;
    private String title;
}
