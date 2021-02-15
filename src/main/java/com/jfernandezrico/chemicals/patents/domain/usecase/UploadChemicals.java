package com.jfernandezrico.chemicals.patents.domain.usecase;

import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;

import java.util.List;

public interface UploadChemicals {

    Integer upload(List<Patent> patents);

    Integer saveNERClassifications(List<Patent> patents);
}
