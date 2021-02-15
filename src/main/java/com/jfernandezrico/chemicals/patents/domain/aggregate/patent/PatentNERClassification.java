package com.jfernandezrico.chemicals.patents.domain.aggregate.patent;

import com.jfernandezrico.chemicals.patents.domain.value.NERClassification;
import lombok.Builder;
import lombok.Data;

@Data @Builder public class PatentNERClassification {
    String id;
    NERClassification classification;
}
