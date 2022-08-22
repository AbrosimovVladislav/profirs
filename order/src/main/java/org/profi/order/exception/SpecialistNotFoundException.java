package org.profi.order.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class SpecialistNotFoundException extends RuntimeException {

  public SpecialistNotFoundException(Long specialistId) {
    super("There is no specialist with id: " + specialistId);
  }
}
