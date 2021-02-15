package com.jfernandezrico.chemicals.patents.boot.config;

import com.jfernandezrico.chemicals.patents.adapter.in.mapper.PatentParser;
import com.jfernandezrico.chemicals.patents.adapter.in.mapper.QuestelPatentParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration public class PatentParserConfig {

    @Bean public PatentParser patentParser() {
        return new QuestelPatentParser();
    }
}
