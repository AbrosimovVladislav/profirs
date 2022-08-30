package org.profi.order.model;

import static org.profi.order.model.Order.ORDER_ID;

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
public class CategoryProperty {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long categoryPropertyId;

  private String key;

  private String values;

  @ManyToOne
  @JoinColumn(name = ORDER_ID, nullable = false)
  private Order order;

}
