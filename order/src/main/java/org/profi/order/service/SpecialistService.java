package org.profi.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.exception.CategoryNotFoundException;
import org.profi.order.exception.SpecialistNotFoundException;
import org.profi.order.model.Category;
import org.profi.order.model.Specialist;
import org.profi.order.repo.CategoryRepo;
import org.profi.order.repo.SpecialistRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpecialistService {

  private final SpecialistRepo specialistRepo;
  private final CategoryRepo categoryRepo;

  public List<Specialist> getAll() {
    return specialistRepo.findAll();
  }

  public Specialist findById(Long specialistId) {
    return specialistRepo.findById(specialistId)
        .orElseThrow(() -> new SpecialistNotFoundException(specialistId));
  }

  public List<Specialist> findByCategoryId(Long categoryId){
    Category category = categoryRepo.findById(categoryId)
            .orElseThrow(() -> new CategoryNotFoundException(categoryId));
    return specialistRepo.findByCategory(category);
  }

}
