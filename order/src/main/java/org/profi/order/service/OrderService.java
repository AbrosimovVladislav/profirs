package org.profi.order.service;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
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

    public List<Order> getAll() {
        return orderRepo.findAll();
    }

    public Order save(Order order) {
        return orderRepo.save(order);
    }

    public Order findById(Long orderId) {
        return orderRepo.findById(orderId).orElseThrow(() -> new OrderNotFoundException(orderId));
    }

    public Order publish(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        validator.validateBeforePublish(order);
        order.setOrderStatus(Order.OrderStatus.PUBLISHED);
        return save(order);
    }

    public Order draft(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        validator.validateBeforeDraft(order);
        order.setOrderStatus(Order.OrderStatus.DRAFT);
        return save(order);
    }

    public Order inProgress(Order order) {
        validator.validateBeforeSetInProgress(order);
        order.setOrderStatus(Order.OrderStatus.IN_PROGRESS);
        return save(order);
    }

    public Order close(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        validator.validateBeforeClose(order);
        order.setOrderStatus(Order.OrderStatus.CLOSED);
        return save(order);
    }

    public Order resolve(Long id) {
        Order order = orderRepo.findById(id).orElseThrow(() -> new OrderNotFoundException(id));

        validator.validateBeforeResolve(order);
        order.setOrderStatus(Order.OrderStatus.RESOLVED);
        return save(order);
    }
}
