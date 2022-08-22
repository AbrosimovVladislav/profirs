package org.profi.order.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {

  private Long orderId;
  private String name;
  private String category;
  private String description;
  private Long customerId;
  private String customerName;
  private Long specialistId;
  private String specialistName;
  private String orderStatus;
}
