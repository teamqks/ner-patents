package com.jfernandezrico.chemicals.patents.domain.processor;

import com.jfernandezrico.chemicals.patents.domain.value.NERClassification;

public interface NERProcessor {
    NERClassification classifyContent(String content);
}

