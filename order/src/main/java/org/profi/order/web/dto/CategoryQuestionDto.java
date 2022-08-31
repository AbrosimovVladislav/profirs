package org.profi.order.web.dto;


import lombok.Builder;
import lombok.Data;
import org.profi.order.model.Question.QuestionType;

@Data
@Builder
public class CategoryQuestionDto {

  private String question;
  private String propertyName;
  private String possibleAnswers;
  private Boolean required;
  private QuestionType questionType;
}
