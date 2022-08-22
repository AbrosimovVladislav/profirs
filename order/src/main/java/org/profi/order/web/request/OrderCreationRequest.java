package org.profi.order.web.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.profi.order.model.Order.OrderStatus;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreationRequest {

  private String name;
  private OrderStatus orderStatus;
  private Long customerId;
  private Long specialistId;
  private String category;
  private String description;

}
