package org.profi.order.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.exception.CategoryNotFoundException;
import org.profi.order.model.Category;
import org.profi.order.repo.CategoryRepo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService {

  private final CategoryRepo categoryRepo;

  public List<Category> getAll() {
    return categoryRepo.findAll();
  }

  public Category findById(Long id) {
    return categoryRepo.findById(id)
        .orElseThrow(() -> new CategoryNotFoundException(id));
  }

  public Category findByShowName(String showName) {
    return categoryRepo.findByShowName(showName)
        .orElseThrow(() -> new CategoryNotFoundException(showName));
  }
}
