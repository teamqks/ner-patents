package com.jfernandezrico.chemicals.patents.adapter.in.mapper;

import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public interface PatentParser {

    Patent parse(String fileName, XMLStreamReader reader) throws XMLStreamException;

}
