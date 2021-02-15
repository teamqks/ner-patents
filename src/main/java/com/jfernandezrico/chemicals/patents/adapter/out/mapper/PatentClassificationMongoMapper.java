package com.jfernandezrico.chemicals.patents.adapter.out.mapper;

import com.jfernandezrico.chemicals.patents.adapter.out.dto.NERClassificationMongoDto;
import com.jfernandezrico.chemicals.patents.adapter.out.dto.PatentNERClassificationMongoDto;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.PatentNERClassification;
import com.jfernandezrico.chemicals.patents.domain.value.NERClassification;

public class PatentClassificationMongoMapper {

    public static PatentNERClassificationMongoDto toPatentClassificationMongoDto(
        PatentNERClassification patentNERClassification) {
        return PatentNERClassificationMongoDto.builder()
            .patentId(patentNERClassification.getId())
            .classification(PatentClassificationMongoMapper
                .toNERClassificationMongoDto(patentNERClassification.getClassification()))
            .build();
    }

    private static NERClassificationMongoDto toNERClassificationMongoDto(
        NERClassification NERClassification) {
        NERClassificationMongoDto.NERClassificationMongoDtoBuilder builder = NERClassificationMongoDto.builder();
        if (!NERClassification.getPersons().isEmpty())
            builder.persons(NERClassification.getPersons());
        if (!NERClassification.getLocations().isEmpty())
            builder.locations(NERClassification.getLocations());
        if(!NERClassification.getOrganizations().isEmpty())
            builder.organizations(NERClassification.getOrganizations());
        return builder.build();
    }
}
