package org.profi.order.service;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.profi.order.exception.OrderNotFoundException;
import org.profi.order.model.Order;
import org.profi.order.model.OrderHistory;
import org.profi.order.repo.OrderHistoryRepo;
import org.profi.order.repo.OrderRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {

  private final OrderRepo orderRepo;
  private final OrderHistoryRepo orderHistoryRepo;

  public List<OrderHistory> getByOrderId(Long orderId) {
    Order order = orderRepo.findById(orderId)
        .orElseThrow(() -> new OrderNotFoundException(orderId));
    return orderHistoryRepo.findByOrder(order);
  }

  public OrderHistory add(Order order, String payload) {
    OrderHistory orderHistory = new OrderHistory()
        .setOrder(order)
        .setEventTime(LocalDateTime.now())
        .setPayload(payload);
    return orderHistoryRepo.save(orderHistory);
  }

  public OrderHistory add(Order order, Order.OrderStatus source, Order.OrderStatus target) {
    OrderHistory orderHistory = new OrderHistory()
        .setOrder(order)
        .setEventTime(LocalDateTime.now())
        .setSource(source)
        .setTarget(target);
    return orderHistoryRepo.save(orderHistory);
  }

  public OrderHistory add(Order order, Order.OrderStatus source, Order.OrderStatus target,
      String payload) {
    OrderHistory orderHistory = new OrderHistory()
        .setOrder(order)
        .setEventTime(LocalDateTime.now())
        .setSource(source)
        .setTarget(target)
        .setPayload(payload);
    return orderHistoryRepo.save(orderHistory);
  }

}
