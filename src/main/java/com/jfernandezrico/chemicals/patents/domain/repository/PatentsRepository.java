package com.jfernandezrico.chemicals.patents.domain.repository;

import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;

import java.util.List;

public interface PatentsRepository {

    Integer savePatents(List<Patent> patents);

    Integer cleanPatents();
}
