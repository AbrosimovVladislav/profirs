package org.profi.order.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.exception.SpecialistNotFoundException;
import org.profi.order.model.Specialist;
import org.profi.order.repo.SpecialistRepo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpecialistService {

  private final SpecialistRepo specialistRepo;

  public List<Specialist> getAll() {
    return specialistRepo.findAll();
  }

  public Specialist findById(Long specialistId) {
    return specialistRepo.findById(specialistId)
        .orElseThrow(() -> new SpecialistNotFoundException(specialistId));
  }

}
