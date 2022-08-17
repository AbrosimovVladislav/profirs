package org.profi.order.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.Type;
import org.profi.order.repo.TypeRepo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class TypeService {

  private final TypeRepo typeRepo;

  public List<Type> getAll() {
    return typeRepo.findAll();
  }

}
