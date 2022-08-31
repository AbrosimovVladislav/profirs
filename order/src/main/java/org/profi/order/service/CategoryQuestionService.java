package org.profi.order.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.profi.order.model.Question;
import org.profi.order.repo.CategoryQuestionRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryQuestionService {

  private final CategoryQuestionRepo categoryQuestionRepo;

  public List<Question> getByCategoryId(Long categoryId) {
    return categoryQuestionRepo.findByCategory(categoryId);
  }
}
