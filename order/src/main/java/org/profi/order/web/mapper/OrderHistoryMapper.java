package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.profi.order.model.OrderHistory;
import org.profi.order.web.dto.OrderHistoryDto;
import org.springframework.stereotype.Component;

@Component
public class OrderHistoryMapper {

  public List<OrderHistoryDto> historiesToDtos(List<OrderHistory> histories) {
    return histories.stream().map(this::historyToDto).collect(Collectors.toList());
  }

  private OrderHistoryDto historyToDto(OrderHistory orderHistory) {
    return OrderHistoryDto.builder()
        .eventTime(orderHistory.getEventTime())
        .source(orderHistory.getSource())
        .target(orderHistory.getTarget())
        .payload(orderHistory.getPayload())
        .orderId(orderHistory.getOrder().getOrderId())
        .orderName(orderHistory.getOrder().getName())
        .build();
  }
}
