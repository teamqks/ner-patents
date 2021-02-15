package com.jfernandezrico.chemicals.patents.adapter.out.dto;

import static com.jfernandezrico.chemicals.patents.adapter.out.MongoPatentClassificationsRepository.PATENT_CLASSIFICATIONS_COLLECTION_NAME;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data @Builder @Document(collection = PATENT_CLASSIFICATIONS_COLLECTION_NAME)
public class PatentNERClassificationMongoDto {

    @Id private ObjectId id;

    @Indexed private String patentId;

    private NERClassificationMongoDto classification;
}
