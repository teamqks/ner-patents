package com.jfernandezrico.chemicals.patents.adapter.in.mapper;

import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiBadContentExtensionException;
import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiBadZipEntryException;
import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiBadZipExtensionException;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface UploadFileMapper {

    List<Patent> toPatents(MultipartFile file)
        throws ApiBadContentExtensionException, ApiBadZipExtensionException,
        ApiBadZipEntryException;
}
