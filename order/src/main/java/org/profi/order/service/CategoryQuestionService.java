package org.profi.order.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.profi.order.model.Category;
import org.profi.order.model.CategoryQuestion;
import org.profi.order.repo.CategoryQuestionRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryQuestionService {

  private final CategoryQuestionRepo categoryQuestionRepo;
  private final CategoryService categoryService;

  public List<CategoryQuestion> getByCategoryId(Long categoryId) {
    Category category = categoryService.findById(categoryId);
    return categoryQuestionRepo.findByCategory(category);
  }
}
