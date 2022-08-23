package org.profi.order.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

  private Long categoryId;
  private String firstLevel;
  private String secondLevel;
  private String thirdLevel;
  private String showName;
}
