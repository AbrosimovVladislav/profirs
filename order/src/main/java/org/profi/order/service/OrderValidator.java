package org.profi.order.service;

import org.profi.order.exception.CannotUpdateOrderStatusException;
import org.profi.order.model.Order;
import org.profi.order.model.Specialist;
import org.springframework.stereotype.Component;

@Component
public class OrderValidator {

    public void validateBeforePublish(Order order) {
        Order.OrderStatus orderStatus = order.getOrderStatus();
        if (!orderStatus.equals(Order.OrderStatus.DRAFT)
                && !orderStatus.equals(Order.OrderStatus.IN_PROGRESS)
                && !orderStatus.equals(Order.OrderStatus.CLOSED)) {
            throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.PUBLISHED);
        }
    }

    public void validateBeforeDraft(Order order) {
        Order.OrderStatus orderStatus = order.getOrderStatus();
        if (!orderStatus.equals(Order.OrderStatus.PUBLISHED)) {
            throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.DRAFT);
        }
    }

    public void validateBeforeSetInProgress(Order order) {
        Order.OrderStatus orderStatus = order.getOrderStatus();
        Specialist specialist = order.getSpecialist();

        //ToDo check if condition is correct
        if (!orderStatus.equals(Order.OrderStatus.PUBLISHED)
                || specialist == null || specialist.getPerson() == null) {
            throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.IN_PROGRESS);
        }
    }

    public void validateBeforeClose(Order order) {
        Order.OrderStatus orderStatus = order.getOrderStatus();
        if (!orderStatus.equals(Order.OrderStatus.PUBLISHED)) {
            throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.CLOSED);
        }
    }

    public void validateBeforeResolve(Order order) {
        Order.OrderStatus orderStatus = order.getOrderStatus();
        if (!orderStatus.equals(Order.OrderStatus.IN_PROGRESS)) {
            throw new CannotUpdateOrderStatusException(orderStatus, Order.OrderStatus.RESOLVED);
        }
    }
}
