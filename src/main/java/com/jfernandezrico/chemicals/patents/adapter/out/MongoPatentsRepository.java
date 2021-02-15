package com.jfernandezrico.chemicals.patents.adapter.out;

import com.jfernandezrico.chemicals.patents.adapter.out.dto.PatentMongoDto;
import com.jfernandezrico.chemicals.patents.adapter.out.mapper.PatentMongoMapper;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class MongoPatentsRepository implements PatentsRepository {

    public static final String PATENTS_COLLECTION_NAME = "patents";

    private final MongoTemplate mongoTemplate;

    @Override
    public Integer savePatents(List<Patent> patents) {
        List<PatentMongoDto> mongoPatents = patents.stream()
            .map(patent -> PatentMongoMapper.toPatentMongoDto(patent))
            .collect(Collectors.toList());
        mongoTemplate.insertAll(mongoPatents);
        return mongoPatents.size();
    }

    @Override
    public Integer cleanPatents(){
        long patentsCount = mongoTemplate.count(new Query(), PATENTS_COLLECTION_NAME);
        mongoTemplate.dropCollection(PATENTS_COLLECTION_NAME);
        return (int) patentsCount;
    }
}
