package com.jfernandezrico.chemicals.patents.domain.usecase;

import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.PatentNERClassification;
import com.jfernandezrico.chemicals.patents.domain.processor.NERProcessor;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentClassificationsRepository;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentsRepository;
import com.jfernandezrico.chemicals.patents.domain.value.NERClassification;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor public class DefaultUploadPatents implements UploadChemicals {

    private final PatentsRepository patentsRepository;
    private final PatentClassificationsRepository patentClassificationsRepository;
    private final NERProcessor nerProcessor;

    @Override public Integer upload(List<Patent> patents) {
        return savePatents(patents);
    }

    private int savePatents(List<Patent> patents) {
        return patentsRepository.savePatents(patents);
    }

    @Override public Integer saveNERClassifications(List<Patent> patents) {
        List<PatentNERClassification> classifications = classifyPatents(patents);
        patentClassificationsRepository.savePatentClassifications(classifications);
        return classifications.size();
    }

    private List<PatentNERClassification> classifyPatents(List<Patent> patents) {
        return patents.stream().map(patent -> {
            NERClassification abstractClassified =
                nerProcessor.classifyContent(patent.getAbstractText());
            /*NERClassification fullTextClassified =
                nerProcessor.classifyContent(patent.getFullText());*/

            NERClassification contentClassified = //(abstractClassified != null) ?
                abstractClassified/*.union(fullTextClassified) :
                (fullTextClassified != null) ? fullTextClassified : null*/;

            return (!validNERClassification(contentClassified)) ? null: buildPatentNERClassification(patent, contentClassified);

        }).filter(patentNERClassification -> patentNERClassification != null)
            .collect(Collectors.toList());
    }

    private boolean validNERClassification(NERClassification classification) {
        return classification != null &&
            (!classification.getLocations().isEmpty() ||
                !classification.getOrganizations().isEmpty() ||
                !classification.getPersons().isEmpty());
    }

    private PatentNERClassification buildPatentNERClassification(Patent patent, NERClassification contentClassified) {
        NERClassification.NERClassificationBuilder builder = NERClassification.builder();
        if (!contentClassified.getPersons().isEmpty())
            builder.persons(contentClassified.getPersons());
        if (!contentClassified.getLocations().isEmpty())
            builder.locations(contentClassified.getLocations());
        if(!contentClassified.getOrganizations().isEmpty())
            builder.organizations(contentClassified.getOrganizations());
        builder.build();

        return PatentNERClassification.builder()
            .id(patent.getId())
            .classification(contentClassified).build();
    }
}
