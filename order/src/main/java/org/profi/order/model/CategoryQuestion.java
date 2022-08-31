package org.profi.order.model;

import static org.profi.order.model.Category.CATEGORY_ID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class CategoryQuestion {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryQuestionId;

  private String question;

  private String propertyName;

  private String possibleAnswers;

  private Boolean required;

  @ManyToOne
  @JoinColumn(name = CATEGORY_ID, nullable = false)
  private Category category;

}
