package com.jfernandezrico.chemicals.patents.boot.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "chemicals")
public class ChemicalsProperties {

    private ExtractionInfo extractionTags;

    @Data
    public static final class ExtractionInfo {
        private List<String> application;
        private List<String> date;
        private List<String> title;
        private List<String> abstractInfo;
        private List<String> fullText;
    }


}
