package com.jfernandezrico.chemicals.patents.boot.config;

import com.jfernandezrico.chemicals.patents.domain.processor.NERProcessor;
import com.jfernandezrico.chemicals.patents.domain.processor.OpenNLPNERProcessor;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.namefind.TokenNameFinderModel;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Configuration public class NERProcessorConfig {


    @Bean public NERProcessor nerProcessor() throws IOException {
        return instantiateOpenNLPNERProcessor();
    }

    private NERProcessor instantiateOpenNLPNERProcessor() throws IOException {
        //Instantiating the TokenizerME class
        TokenizerME tokenizer = createTokenizerME("opennlp/en-token.bin");

        //Instantiating the NameFinder classes
        NameFinderME personNameFinder = createNameFinderME("opennlp/en-ner-person.bin");
        NameFinderME locationNameFinder = createNameFinderME("opennlp/en-ner-location.bin");
        NameFinderME organizationNameFinder = createNameFinderME("opennlp/en-ner-organization.bin");

        return new OpenNLPNERProcessor(tokenizer, personNameFinder, locationNameFinder,
            organizationNameFinder);
    }

    private NameFinderME createNameFinderME(String nerBinPath) throws IOException {
        InputStream inputStreamPersonTokenizer = new FileInputStream(nerBinPath);
        TokenNameFinderModel model = new TokenNameFinderModel(inputStreamPersonTokenizer);

        //Instantiating the NameFinder class
        return new NameFinderME(model);
    }

    private TokenizerME createTokenizerME(String nerBinPath) throws IOException {
        InputStream inputStreamTokenizer = new FileInputStream(nerBinPath);
        TokenizerModel tokenModel = new TokenizerModel(inputStreamTokenizer);

        //Instantiating the TokenizerME class
        return new TokenizerME(tokenModel);
    }
}
