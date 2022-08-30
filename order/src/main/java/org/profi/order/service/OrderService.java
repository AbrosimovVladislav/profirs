package org.profi.order.service;

import static org.profi.order.model.Order.OrderStatus.CLOSED;
import static org.profi.order.model.Order.OrderStatus.DRAFT;
import static org.profi.order.model.Order.OrderStatus.IN_PROGRESS;
import static org.profi.order.model.Order.OrderStatus.PUBLISHED;
import static org.profi.order.model.Order.OrderStatus.RESOLVED;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.exception.OrderNotFoundException;
import org.profi.order.model.Order;
import org.profi.order.repo.OrderRepo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {

  private final OrderRepo orderRepo;

  private final OrderValidator validator;

  private final OrderHistoryService orderHistoryService;
  private final CategoryPropertiesService categoryPropertiesService;

  public List<Order> getAll() {
    return orderRepo.findAll();
  }

  public Order create(Order order) {
    order.setOrderStatus(DRAFT);
    Order saved = save(order);
    categoryPropertiesService.savePropertiesForOrder(order);
    orderHistoryService.add(saved, null, DRAFT);
    return saved;
  }

  public Order findById(Long orderId) {
    return orderRepo.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
  }

  public Order publish(Long id) {
    Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    Order.OrderStatus oldStatus = order.getOrderStatus();

    if (oldStatus.equals(IN_PROGRESS)) {
      order.setSpecialist(null);
    }

    validator.validateBeforePublish(order);
    order.setOrderStatus(PUBLISHED);
    orderHistoryService.add(order, oldStatus, PUBLISHED);
    return save(order);
  }

  public Order draft(Long id) {
    Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    Order.OrderStatus oldStatus = order.getOrderStatus();

    validator.validateBeforeDraft(order);
    order.setOrderStatus(DRAFT);
    orderHistoryService.add(order, oldStatus, DRAFT);
    return save(order);
  }

  public Order inProgress(Order order) {
    Order.OrderStatus oldStatus = order.getOrderStatus();

    validator.validateBeforeSetInProgress(order);
    order.setOrderStatus(Order.OrderStatus.IN_PROGRESS);
    orderHistoryService.add(order, oldStatus, IN_PROGRESS,
        "Specialist added, id: " + order.getSpecialist().getSpecialistId()
            + " , with name: " + order.getSpecialist().getPerson().getName());
    return save(order);
  }

  public Order close(Long id) {
    Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    Order.OrderStatus oldStatus = order.getOrderStatus();

    validator.validateBeforeClose(order);
    order.setOrderStatus(Order.OrderStatus.CLOSED);
    orderHistoryService.add(order, oldStatus, CLOSED);
    return save(order);
  }

  public Order resolve(Long id) {
    Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));
    Order.OrderStatus oldStatus = order.getOrderStatus();

    validator.validateBeforeResolve(order);
    order.setOrderStatus(Order.OrderStatus.RESOLVED);
    orderHistoryService.add(order, oldStatus, RESOLVED);
    return save(order);
  }

  private Order save(Order order) {
    return orderRepo.save(order);
  }
}
