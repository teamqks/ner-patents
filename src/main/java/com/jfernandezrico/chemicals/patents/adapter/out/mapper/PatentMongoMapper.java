package com.jfernandezrico.chemicals.patents.adapter.out.mapper;

import com.jfernandezrico.chemicals.patents.adapter.out.dto.MetadataMongoDto;
import com.jfernandezrico.chemicals.patents.adapter.out.dto.PatentMongoDto;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;

public class PatentMongoMapper {

    public static PatentMongoDto toPatentMongoDto(Patent patent) {
        return PatentMongoDto.builder()
            .patentId(patent.getId())
            .metadata(MetadataMongoDto.builder()
                .application(patent.getMetadata().getApplication())
                .title(patent.getMetadata().getTitle())
                .year(patent.getMetadata().getYear())
                .build())
            .abstractText(patent.getAbstractText())
            .build();
    }
}
