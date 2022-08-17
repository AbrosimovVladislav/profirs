package org.profi.order.web.api;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.Order;
import org.profi.order.service.OrderService;
import org.profi.order.web.dto.OrderDto;
import org.profi.order.web.mapper.OrderMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@MeasurePerformance
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

  private final OrderService orderService;
  private final OrderMapper orderMapper;

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<OrderDto> getOrders() {
    List<Order> orders = orderService.getAll();
    List<OrderDto> dtos = orders.stream().map(orderMapper::orderToDto)
        .collect(Collectors.toList());
    log.info("GetOrders request: " + dtos);
    return dtos;
  }

}
