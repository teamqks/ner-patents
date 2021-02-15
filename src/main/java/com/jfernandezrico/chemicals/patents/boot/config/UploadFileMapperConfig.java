package com.jfernandezrico.chemicals.patents.boot.config;

import com.jfernandezrico.chemicals.patents.adapter.in.mapper.UploadFileMapper;
import com.jfernandezrico.chemicals.patents.adapter.in.mapper.UploadZipXMLFileMapper;
import com.jfernandezrico.chemicals.patents.adapter.in.mapper.PatentParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadFileMapperConfig {

    @Bean
    public UploadFileMapper uploadFileMapper(PatentParser patentParser) {
        return new UploadZipXMLFileMapper(patentParser);
    }
}
