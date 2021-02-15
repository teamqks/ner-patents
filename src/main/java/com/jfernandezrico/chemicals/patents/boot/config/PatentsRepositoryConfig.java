package com.jfernandezrico.chemicals.patents.boot.config;

import com.jfernandezrico.chemicals.patents.adapter.out.MongoPatentsRepository;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;


@Configuration
public class PatentsRepositoryConfig {

    @Bean
    public PatentsRepository patentsRepository(MongoTemplate mongoTemplate) {
        return new MongoPatentsRepository(mongoTemplate);
    }
}
