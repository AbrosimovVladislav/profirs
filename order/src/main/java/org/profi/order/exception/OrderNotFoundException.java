package org.profi.order.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class OrderNotFoundException extends RuntimeException {

  public OrderNotFoundException(Long orderId) {
    super("There is no order with id: " + orderId);
  }
}
