package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.profi.order.model.Order;
import org.profi.order.web.dto.OrderDto;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

  public List<OrderDto> ordersToDtos(List<Order> orders) {
    return orders.stream().map(this::orderToDto).collect(Collectors.toList());
  }

  public OrderDto orderToDto(Order order) {
    return OrderDto.builder()
        .name(order.getName())
        .type(order.getType().getName())
        .build();
  }
}
