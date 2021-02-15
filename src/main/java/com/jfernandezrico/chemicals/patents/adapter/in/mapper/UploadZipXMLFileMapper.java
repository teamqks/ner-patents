package com.jfernandezrico.chemicals.patents.adapter.in.mapper;

import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiBadContentExtensionException;
import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiBadZipEntryException;
import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiBadZipExtensionException;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.input.CloseShieldInputStream;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

@RequiredArgsConstructor public class UploadZipXMLFileMapper implements UploadFileMapper {

    private static final String XML_EXTENSION = "xml";
    private static final String ZIP_EXTENSION = "zip";

    private final XMLInputFactory factory = XMLInputFactory.newInstance();

    private final PatentParser patentParser;

    @Override public List<Patent> toPatents(MultipartFile file)
        throws ApiBadContentExtensionException, ApiBadZipExtensionException,
        ApiBadZipEntryException {
        String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!fileExtension.equalsIgnoreCase(ZIP_EXTENSION))
            throw new ApiBadZipExtensionException(fileExtension);

        List<Patent> patents = new ArrayList<>();
        try {
            ZipInputStream zipInputStream = new ZipInputStream(file.getInputStream());
            ZipEntry ze;
            while ((ze = zipInputStream.getNextEntry()) != null) {
                String fileName = ze.getName();
                if (!FilenameUtils.getExtension(fileName).equalsIgnoreCase(XML_EXTENSION)) {
                    throw new ApiBadContentExtensionException(ze.getName());
                }
                XMLStreamReader reader =
                    factory.createXMLStreamReader(new CloseShieldInputStream(zipInputStream));
                Patent patent = patentParser.parse(fileName, reader);
                if (patent != null)
                    patents.add(patent);
                zipInputStream.closeEntry();
            }
        } catch (IOException | XMLStreamException e) {
            throw new ApiBadZipEntryException(e.getMessage());
        }

        return patents;
    }

}
