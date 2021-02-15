package com.jfernandezrico.chemicals.patents.domain.usecase;

import com.jfernandezrico.chemicals.patents.domain.repository.PatentClassificationsRepository;
import com.jfernandezrico.chemicals.patents.domain.repository.PatentsRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DefaultCleanPatents implements CleanPatents {

    private final PatentsRepository patentsRepository;
    private final PatentClassificationsRepository patentClassificationsRepository;

    @Override
    public Integer cleanPatents(){
        return patentsRepository.cleanPatents();
    }

    @Override
    public Integer cleanNERClassifications(){
        return patentClassificationsRepository.cleanPatentClassifications();
    }
}
