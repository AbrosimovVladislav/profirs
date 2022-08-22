package org.profi.order.exception;

import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
@NoArgsConstructor
public class CategoryNotFoundException extends RuntimeException {

  public CategoryNotFoundException(String categoryShowName) {
    super("There is no category with show name: " + categoryShowName);
  }
}
