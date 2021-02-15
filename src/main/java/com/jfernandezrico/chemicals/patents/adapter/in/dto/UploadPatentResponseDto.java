package com.jfernandezrico.chemicals.patents.adapter.in.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

/**
 * ModelApiResponse
 */
@Validated
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "UploadPatentResponseDto", description = "Response for Patent Upload Operations")
public class UploadPatentResponseDto {

  private Integer patentsUploaded;
  private Integer classificationsUploaded;

}

