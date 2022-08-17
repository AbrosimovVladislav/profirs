package org.profi.clients.order;

import java.util.List;
import org.profi.clients.order.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "order")
public interface OrderClient {

  @GetMapping(path = "api/v1/order/order")
  List<OrderDto> getOrders();

}
