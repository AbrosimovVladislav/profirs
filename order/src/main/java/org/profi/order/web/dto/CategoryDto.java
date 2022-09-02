package org.profi.order.web.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryDto {

  private Long id;
  private String firstLevel;
  private String secondLevel;
  private String thirdLevel;
  private String title;
  private String link;
  private List<CategoryDto> children;
}
