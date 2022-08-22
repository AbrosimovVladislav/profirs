package org.profi.clients.order.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderDto {

  private String name;
  private String category;
  private String description;
  private Long customerId;
  private String customerName;
  private Long specialistId;
  private String specialistName;
  private String orderStatus;
}
