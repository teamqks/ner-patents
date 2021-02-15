package com.jfernandezrico.chemicals.patents.adapter.in.dto;

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
@ApiModel(value = "BadRequestResponseDto", description = "Response Bad Request")
public class BadRequestResponseDto {

  private int internalCode;
  private String message;

}

