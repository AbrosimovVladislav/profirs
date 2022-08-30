package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.profi.order.model.CategoryProperty;
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
}
