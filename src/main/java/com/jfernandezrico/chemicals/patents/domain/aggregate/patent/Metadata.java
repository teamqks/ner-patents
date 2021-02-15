package com.jfernandezrico.chemicals.patents.domain.aggregate.patent;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Metadata {
    private String application;
    private Integer year;
    private String title;
}
