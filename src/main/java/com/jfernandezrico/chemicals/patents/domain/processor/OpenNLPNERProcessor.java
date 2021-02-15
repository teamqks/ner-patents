package com.jfernandezrico.chemicals.patents.domain.processor;

import com.jfernandezrico.chemicals.patents.domain.value.NERClassification;
import lombok.RequiredArgsConstructor;
import opennlp.tools.namefind.NameFinderME;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.util.Span;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor public class OpenNLPNERProcessor implements NERProcessor {

    private final TokenizerME tokenizer;
    private final NameFinderME personNameFinder;
    private final NameFinderME locationFinder;
    private final NameFinderME organizationFinder;


    @Override public NERClassification classifyContent(String content) {
        if (content != null) {
            String[] tokens = getTokens(content);
            return NERClassification.builder().persons(findPersons(tokens))
                .organizations(findOrganizations(tokens)).locations(findLocations(tokens)).build();
        }
        return null;
    }

    private String[] getTokens(String text) {
        return tokenizer.tokenize(text);
    }

    private Set<String> findPersons(String[] tokens) {
        return spansToStringSet(personNameFinder.find(tokens), tokens);
    }

    private Set<String> findLocations(String[] tokens) {
        return spansToStringSet(locationFinder.find(tokens), tokens);
    }

    private Set<String> findOrganizations(String[] tokens) {
        return spansToStringSet(organizationFinder.find(tokens), tokens);
    }

    private Set<String> spansToStringSet(Span[] spans, String[] tokens) {
        return Arrays.stream(spans).map(span -> tokens[span.getStart()])
            .collect(Collectors.toSet());
    }

}
