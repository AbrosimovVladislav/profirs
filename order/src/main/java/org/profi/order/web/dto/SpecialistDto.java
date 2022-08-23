package org.profi.order.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecialistDto {

  private Long specialistId;
  private Long personId;
  private String name;

}
