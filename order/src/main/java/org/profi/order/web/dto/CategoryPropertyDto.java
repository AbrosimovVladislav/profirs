package org.profi.order.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryPropertyDto {

  private String key;
  private String value;
}