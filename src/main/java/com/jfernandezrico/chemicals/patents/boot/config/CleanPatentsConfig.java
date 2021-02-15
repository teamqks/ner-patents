package com.jfernandezrico.chemicals.patents.boot.config;

import com.jfernandezrico.chemicals.patents.domain.repository.PatentClassificationsRepository;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentsRepository;
import com.jfernandezrico.chemicals.patents.domain.usecase.CleanPatents;
import com.jfernandezrico.chemicals.patents.domain.usecase.DefaultCleanPatents;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class CleanPatentsConfig {

    @Bean public CleanPatents cleanChemicals(PatentsRepository patentsRepository, PatentClassificationsRepository patentClassificationsRepository) {
        return new DefaultCleanPatents(patentsRepository, patentClassificationsRepository);
    }
}
