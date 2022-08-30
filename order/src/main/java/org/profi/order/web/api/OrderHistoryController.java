package org.profi.order.web.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.OrderHistory;
import org.profi.order.service.OrderHistoryService;
import org.profi.order.web.dto.OrderHistoryDto;
import org.profi.order.web.mapper.OrderHistoryMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@MeasurePerformance
@RequestMapping("api/v1/order-history")
@RequiredArgsConstructor
public class OrderHistoryController {

  private final OrderHistoryService orderHistoryService;
  private final OrderHistoryMapper orderHistoryMapper;

  @GetMapping(value = "/{orderId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<OrderHistory> getHistoryByOrderId(@PathVariable Long orderId) {
    List<OrderHistory> histories = orderHistoryService.getByOrderId(orderId);
    List<OrderHistoryDto> dtos = orderHistoryMapper.historiesToDtos(histories);
    log.info("GetOrderHistoryById request: " + histories);
    return histories;
  }

}
