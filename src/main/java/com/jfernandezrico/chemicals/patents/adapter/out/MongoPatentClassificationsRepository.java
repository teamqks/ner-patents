package com.jfernandezrico.chemicals.patents.adapter.out;

import com.jfernandezrico.chemicals.patents.adapter.out.dto.PatentNERClassificationMongoDto;
import com.jfernandezrico.chemicals.patents.adapter.out.mapper.PatentClassificationMongoMapper;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.PatentNERClassification;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentClassificationsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MongoPatentClassificationsRepository implements PatentClassificationsRepository {

    public static final String PATENT_CLASSIFICATIONS_COLLECTION_NAME = "patentClassifications";

    private final MongoTemplate mongoTemplate;

    @Override
    public Integer savePatentClassifications(List<PatentNERClassification> patentNERClassifications) {
        List<PatentNERClassificationMongoDto> mongoPatentClassifications =
            patentNERClassifications.stream()
            .map(patentClassification -> PatentClassificationMongoMapper
                .toPatentClassificationMongoDto(patentClassification))
            .collect(Collectors.toList());
        mongoTemplate.insertAll(mongoPatentClassifications);
        return mongoPatentClassifications.size();
    }

    @Override
    public Integer cleanPatentClassifications(){
        long patentsCount = mongoTemplate.count(new Query(), PATENT_CLASSIFICATIONS_COLLECTION_NAME);
        mongoTemplate.dropCollection(PATENT_CLASSIFICATIONS_COLLECTION_NAME);
        return (int) patentsCount;
    }
}
