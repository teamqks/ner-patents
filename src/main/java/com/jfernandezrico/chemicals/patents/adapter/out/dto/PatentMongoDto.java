package com.jfernandezrico.chemicals.patents.adapter.out.dto;

import static com.jfernandezrico.chemicals.patents.adapter.out.MongoPatentsRepository.PATENTS_COLLECTION_NAME;

import lombok.Builder;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = PATENTS_COLLECTION_NAME)
public class PatentMongoDto {

    @Id
    private ObjectId id;

    @Indexed
    private String patentId;

    private MetadataMongoDto metadata;

    @Field("abstract")
    private String abstractText;
}
