package org.profi.order.web.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryQuestionDto {

  private String question;
  private String propertyName;
  private String possibleAnswers;
  private String category;
}
