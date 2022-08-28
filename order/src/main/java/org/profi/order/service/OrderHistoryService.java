package org.profi.order.service;

import lombok.RequiredArgsConstructor;
import org.profi.order.model.Order;
import org.profi.order.model.OrderHistory;
import org.profi.order.repo.OrderHistoryRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OrderHistoryService {

    private final OrderHistoryRepo orderHistoryRepo;

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

    public OrderHistory add(Order order, Order.OrderStatus source, Order.OrderStatus target, String payload) {
        OrderHistory orderHistory = new OrderHistory()
                .setOrder(order)
                .setEventTime(LocalDateTime.now())
                .setSource(source)
                .setTarget(target)
                .setPayload(payload);
        return orderHistoryRepo.save(orderHistory);
    }

}
