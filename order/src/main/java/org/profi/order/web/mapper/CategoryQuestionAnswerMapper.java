package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.profi.order.model.CategoryProperty;
import org.profi.order.model.CategoryQuestion;
import org.profi.order.web.dto.CategoryQuestionDto;
import org.profi.order.web.request.CustomerAnswer;
import org.springframework.stereotype.Component;

@Component
public class CategoryQuestionAnswerMapper {


  public List<CategoryProperty> answersToProperties(List<CustomerAnswer> customerAnswers) {
    return customerAnswers.stream().map(this::answerToProperty).collect(Collectors.toList());
  }

  public CategoryProperty answerToProperty(CustomerAnswer customerAnswer) {
    return new CategoryProperty()
        .setKey(customerAnswer.getPropertyName())
        .setValues(customerAnswer.getAnswer());
  }

  public List<CategoryQuestionDto> questionsToDtos(List<CategoryQuestion> questions) {
    return questions.stream().map(this::questionToDto).collect(Collectors.toList());
  }

  public CategoryQuestionDto questionToDto(CategoryQuestion question) {
    return CategoryQuestionDto.builder()
        .category(question.getCategory().getShowName())
        .question(question.getQuestion())
        .possibleAnswers(question.getPossibleAnswers())
        .propertyName(question.getPropertyName())
        .required(question.getRequired())
        .build();
  }
}
