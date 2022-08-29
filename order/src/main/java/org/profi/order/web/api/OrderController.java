package org.profi.order.web.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.Order;
import org.profi.order.service.OrderService;
import org.profi.order.web.dto.OrderDto;
import org.profi.order.web.mapper.OrderMapper;
import org.profi.order.web.request.OrderCreationRequest;
import org.profi.order.web.request.OrderSetInProgressRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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


  @PostMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public OrderDto createOrder(@RequestBody OrderCreationRequest request) {
    Order order = orderMapper.creationRequestToOrder(request);
    Order saved = orderService.create(order);
    OrderDto savedDto = orderMapper.orderToDto(saved);
    log.info("Create order request: " + request);
    return savedDto;
  }

  @PatchMapping(value = "/publish/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public OrderDto publishOrder(@PathVariable Long id) {
    Order published = orderService.publish(id);
    OrderDto orderDto = orderMapper.orderToDto(published);
    log.info("Order published: " + orderDto);
    return orderDto;
  }

  @PatchMapping(value = "/draft/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public OrderDto draftOrder(@PathVariable Long id) {
    Order drafted = orderService.draft(id);
    OrderDto orderDto = orderMapper.orderToDto(drafted);
    log.info("Order drafted: " + orderDto);
    return orderDto;
  }

  @PatchMapping(value = "/inProgress", produces = MediaType.APPLICATION_JSON_VALUE)
  public OrderDto inProgressOrder(@RequestBody OrderSetInProgressRequest request) {
    Order order = orderMapper.setInProgressRequestToOrder(request);
    Order inProgressed = orderService.inProgress(order);
    OrderDto orderDto = orderMapper.orderToDto(inProgressed);
    log.info("Order set in progress: " + orderDto);
    return orderDto;
  }

  @PatchMapping(value = "/close/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public OrderDto closeOrder(@PathVariable Long id) {
    Order closed = orderService.close(id);
    OrderDto orderDto = orderMapper.orderToDto(closed);
    log.info("Order closed: " + orderDto);
    return orderDto;
  }

  @PatchMapping(value = "/resolve/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public OrderDto resolveOrder(@PathVariable Long id) {
    Order resolved = orderService.resolve(id);
    OrderDto orderDto = orderMapper.orderToDto(resolved);
    log.info("Order resolved: " + orderDto);
    return orderDto;
  }

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<OrderDto> getOrders() {
    List<Order> orders = orderService.getAll();
    List<OrderDto> dtos = orderMapper.ordersToDtos(orders);
    log.info("GetOrders request: " + dtos);
    return dtos;
  }

}
