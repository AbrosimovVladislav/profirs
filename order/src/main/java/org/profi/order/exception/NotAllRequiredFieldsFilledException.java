package org.profi.order.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class NotAllRequiredFieldsFilledException extends RuntimeException {

  public NotAllRequiredFieldsFilledException(String notFilledProperties) {
    super("Not all required fields filled. Not filled: " + notFilledProperties);
  }

}
