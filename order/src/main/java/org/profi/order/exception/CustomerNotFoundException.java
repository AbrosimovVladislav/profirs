package org.profi.order.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class CustomerNotFoundException extends RuntimeException {

  public CustomerNotFoundException(Long customerId) {
    super("There is no customer with id: " + customerId);
  }
}
