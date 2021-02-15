package com.jfernandezrico.chemicals.patents.domain.aggregate.patent;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Patent {

    private String id;
    private Metadata metadata;
    private String abstractText;
    private String fullText;
}
