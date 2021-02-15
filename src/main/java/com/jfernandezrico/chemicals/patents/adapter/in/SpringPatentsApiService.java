package com.jfernandezrico.chemicals.patents.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jfernandezrico.chemicals.patents.adapter.in.dto.BadRequestResponseDto;
import com.jfernandezrico.chemicals.patents.adapter.in.dto.CleanPatentsResponseDto;
import com.jfernandezrico.chemicals.patents.adapter.in.dto.UploadPatentResponseDto;
import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiErrorException;
import com.jfernandezrico.chemicals.patents.adapter.in.exception.ApiTagNotFoundException;
import com.jfernandezrico.chemicals.patents.adapter.in.mapper.UploadFileMapper;
import com.jfernandezrico.chemicals.patents.adapter.in.mapper.UploadZipXMLFileMapper;
import com.jfernandezrico.chemicals.patents.domain.aggregate.patent.Patent;
import com.jfernandezrico.chemicals.patents.domain.exception.TagNotFoundException;
import com.jfernandezrico.chemicals.patents.domain.usecase.CleanPatents;
import com.jfernandezrico.chemicals.patents.domain.usecase.UploadChemicals;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;


@Controller
@AllArgsConstructor
public class SpringPatentsApiService
    implements PatentsApiService {

    private static final Logger log = LoggerFactory.getLogger(SpringPatentsApiService.class);

    private final ObjectMapper objectMapper;
    private final HttpServletRequest request;
    private final UploadChemicals uploadChemicals;
    private final CleanPatents cleanPatents;
    private final UploadFileMapper uploadFileMapper;

    public ResponseEntity<CleanPatentsResponseDto> deleteAll() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            int patentsRemoved = cleanPatents.cleanPatents();
            int classificationsRemoved = cleanPatents.cleanNERClassifications();
            return new ResponseEntity(new CleanPatentsResponseDto(patentsRemoved, classificationsRemoved), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<UploadPatentResponseDto> uploadFile(
        @ApiParam(value = "zip file to upload") @Valid @RequestPart(value = "file", required = true)
            MultipartFile file) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                List<Patent> patents = uploadFileMapper.toPatents(file);
                int patentsUploaded = uploadChemicals.upload(patents);
                int classificationsUploaded = uploadChemicals.saveNERClassifications(patents);
                return new ResponseEntity(new UploadPatentResponseDto(patentsUploaded, classificationsUploaded), HttpStatus.OK);
            } catch (ApiErrorException e) {
                return new ResponseEntity(new BadRequestResponseDto(e.getInternalCode(), e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
            }
        }

        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}
