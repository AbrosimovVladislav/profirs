package org.profi.order.exception;

import lombok.NoArgsConstructor;
import org.profi.order.model.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class CannotUpdateOrderStatusException extends RuntimeException {

    public CannotUpdateOrderStatusException(Order.OrderStatus status, Order.OrderStatus target) {
        super(status.equals(Order.OrderStatus.PUBLISHED) && target.equals(Order.OrderStatus.IN_PROGRESS)
                ? "Impossible to set status of order to IN_PROGRESS if there is no specialist"
                : "Can not set order status to " + target + " from status " + status);
    }
}
