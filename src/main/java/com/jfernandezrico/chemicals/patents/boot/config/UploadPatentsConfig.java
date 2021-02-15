package com.jfernandezrico.chemicals.patents.boot.config;

import com.jfernandezrico.chemicals.patents.domain.repository.PatentClassificationsRepository;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentsRepository;
import com.jfernandezrico.chemicals.patents.domain.usecase.DefaultUploadPatents;
import com.jfernandezrico.chemicals.patents.domain.usecase.UploadChemicals;
import com.jfernandezrico.chemicals.patents.domain.processor.NERProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UploadPatentsConfig {

    @Bean
    public UploadChemicals uploadChemicals(PatentsRepository patentsRepository,
        PatentClassificationsRepository patentClassificationsRepository, NERProcessor NERProcessor) {
        return new DefaultUploadPatents(patentsRepository, patentClassificationsRepository, NERProcessor);
    }
}
