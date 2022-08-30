package org.profi.order.web.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.profi.order.model.Order.OrderStatus;

@Data
@Builder
public class OrderHistoryDto {

  private LocalDateTime eventTime;
  private OrderStatus source;
  private OrderStatus target;
  private String payload;
  private Long orderId;
  private String orderName;

}
