package com.jfernandezrico.chemicals.patents.domain.repository;

import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.PatentNERClassification;

import java.util.List;

public interface PatentClassificationsRepository {

    Integer savePatentClassifications(List<PatentNERClassification> patentNERClassifications);

    Integer cleanPatentClassifications();
}
