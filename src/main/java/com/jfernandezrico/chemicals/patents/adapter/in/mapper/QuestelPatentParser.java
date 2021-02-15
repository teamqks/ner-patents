package com.jfernandezrico.chemicals.patents.adapter.in.mapper;

import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Metadata;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;
import org.apache.commons.io.FilenameUtils;

import java.util.Locale;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class QuestelPatentParser implements PatentParser {

    private static final String ELEMENT_APPLICATION_REFERENCE = "application-reference";
    private static final String ELEMENT_DATE = "date";
    private static final String ELEMENT_TITLE = "invention-title";
    private static final String ELEMENT_ABSTRACT = "abstract";
    private static final String ELEMENT_TEXT = "description";
    private static final String ELEMENT_PUBLICATION_REFERENCE = "publication-reference";
    private static final String ELEMENT_DOC_NUMBER = "doc-number";

    @Override
    public Patent parse(String fileName, XMLStreamReader reader) throws XMLStreamException {

        Patent.PatentBuilder patentBuilder = Patent.builder();
        Metadata.MetadataBuilder metadataBuilder = Metadata.builder();
        Patent patent = null;
        TagStatus applicationReferenceTagStatus = TagStatus.NOT_ACCESSED;
        TagStatus publicationReferenceTagStatus = TagStatus.NOT_ACCESSED;
        TagStatus abstractTagStatus = TagStatus.NOT_ACCESSED;
        TagStatus textTagStatus = TagStatus.NOT_ACCESSED;
        boolean applicationProcessed = false;
        boolean dateProcessed = false;

        patentBuilder.id(FilenameUtils.removeExtension(fileName));

        int event;
        String tag;
        StringBuilder stringBuilder = new StringBuilder();

        while (reader.hasNext()) {
            event = reader.next();
            switch (event) {
                case XMLEvent.START_ELEMENT:
                    tag = reader.getLocalName().toLowerCase(Locale.ROOT);
                    switch (tag) {
                        case ELEMENT_APPLICATION_REFERENCE:
                            applicationReferenceTagStatus = TagStatus.OPENED;
                            break;
                        case ELEMENT_DOC_NUMBER:
                            if (applicationReferenceTagStatus == TagStatus.OPENED && !applicationProcessed) {
                                metadataBuilder.application(reader.getElementText());
                                applicationProcessed = true;
                            }
                            break;
                        case ELEMENT_TITLE:
                            metadataBuilder.title(reader.getElementText());
                            break;
                        case ELEMENT_ABSTRACT:
                            abstractTagStatus = TagStatus.OPENED;
                            break;
                        case ELEMENT_TEXT:
                            textTagStatus = TagStatus.OPENED;
                            break;
                        case ELEMENT_DATE:
                            if (publicationReferenceTagStatus == TagStatus.OPENED && !dateProcessed) {
                                metadataBuilder.year(Integer.parseInt(reader.getElementText()));
                                dateProcessed = true;
                            }
                            break;
                        case ELEMENT_PUBLICATION_REFERENCE:
                            publicationReferenceTagStatus = TagStatus.OPENED;
                            break;
                        default:
                            break;
                    }
                    break;
                case XMLEvent.END_ELEMENT:
                    tag = reader.getLocalName().toLowerCase(Locale.ROOT);
                    switch (tag) {
                        case ELEMENT_PUBLICATION_REFERENCE:
                            publicationReferenceTagStatus = TagStatus.CLOSED;
                        case ELEMENT_APPLICATION_REFERENCE:
                            applicationReferenceTagStatus = TagStatus.CLOSED;
                            break;
                        case ELEMENT_ABSTRACT:
                            abstractTagStatus = TagStatus.CLOSED;
                            patentBuilder.abstractText(stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            break;
                        case ELEMENT_TEXT:
                            textTagStatus = TagStatus.CLOSED;
                            patentBuilder.fullText(stringBuilder.toString());
                            stringBuilder = new StringBuilder();
                            break;
                    }
                    break;
                case XMLEvent.END_DOCUMENT:
                    patent = patentBuilder
                        .metadata(metadataBuilder.build())
                        .build();
                    break;
                case XMLEvent.CHARACTERS:
                    if (abstractTagStatus == TagStatus.OPENED || textTagStatus == TagStatus.OPENED)
                        stringBuilder.append(reader.getText());
                    break;
            }
        }
        return patent;
    }


}
