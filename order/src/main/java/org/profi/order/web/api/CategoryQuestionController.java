package org.profi.order.web.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.CategoryQuestion;
import org.profi.order.service.CategoryQuestionService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@MeasurePerformance
@RequestMapping("api/v1/category-question")
@RequiredArgsConstructor
public class CategoryQuestionController {

  private final CategoryQuestionService categoryQuestionService;

  @GetMapping(value = "/{categoryName}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CategoryQuestion> getQuestionsByCategory(@PathVariable String categoryName) {
    List<CategoryQuestion> categories = categoryQuestionService.getByCategoryName(categoryName);
    log.info("GetQuestionsByCategory request: " + categories);
    return categories;
  }

}
