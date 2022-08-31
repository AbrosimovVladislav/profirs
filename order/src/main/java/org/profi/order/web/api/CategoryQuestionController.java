package org.profi.order.web.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.CategoryQuestion;
import org.profi.order.service.CategoryQuestionService;
import org.profi.order.web.dto.CategoryQuestionDto;
import org.profi.order.web.mapper.CategoryQuestionAnswerMapper;
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
  private final CategoryQuestionAnswerMapper categoryQuestionAnswerMapper;

  @GetMapping(value = "/{categoryId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CategoryQuestionDto> getQuestionsByCategoryId(@PathVariable Long categoryId) {
    List<CategoryQuestion> questions = categoryQuestionService.getByCategoryId(categoryId);
    List<CategoryQuestionDto> dtos = categoryQuestionAnswerMapper.questionsToDtos(questions);
    log.info("GetQuestionsByCategory request: " + dtos);
    return dtos;
  }

}
