package org.profi.order.model;

import static org.profi.order.model.Category.CATEGORY_ID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Question {

  public static final String QUESTION_ID = "question_id";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long questionId;

  private String questionValue;

  private String propertyName;

  private String possibleAnswers;

  private Boolean required;

  @Enumerated(EnumType.STRING)
  private QuestionType questionType;

  @ManyToMany
  @JsonIgnore
  @JoinTable(
      name = "category_question",
      joinColumns = @JoinColumn(name = QUESTION_ID),
      inverseJoinColumns = @JoinColumn(name = CATEGORY_ID)
  )
  private List<Category> categories;

  public enum QuestionType {
    ONE_CHOICE, MULTIPLE_CHOICE, RANGE_CHOICE, TEXT_FIELD
  }

}
