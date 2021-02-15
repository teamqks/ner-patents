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
@ApiModel(value = "CleanPatentsResponseDto", description = "Response for Clean Patents Operations")
public class CleanPatentsResponseDto {

  private Integer patentsRemoved;
  private Integer classificationsRemoved;

}

