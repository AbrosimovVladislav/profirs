package org.profi.order.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {

  private String name;
  private String type;
}
