package com.jfernandezrico.chemicals.patents.boot.config;

import com.jfernandezrico.chemicals.patents.adapter.out.MongoPatentClassificationsRepository;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentClassificationsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration public class PatentClassificationsRepositoryConfig {

    @Bean public PatentClassificationsRepository patentClassificationsRepository(MongoTemplate mongoTemplate) {
        return new MongoPatentClassificationsRepository(mongoTemplate);
    }
}
