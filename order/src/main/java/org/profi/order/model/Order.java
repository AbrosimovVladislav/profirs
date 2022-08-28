package org.profi.order.model;

import static org.profi.order.model.Category.CATEGORY_ID;
import static org.profi.order.model.Customer.CUSTOMER_ID;
import static org.profi.order.model.Specialist.SPECIALIST_ID;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.*;
import lombok.experimental.Accessors;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderId;

  private String name;

  @ManyToOne
  @JoinColumn(name = CUSTOMER_ID, nullable = false)
  private Customer customer;

  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;

  @ManyToOne
  @JoinColumn(name = SPECIALIST_ID)
  private Specialist specialist;

  @ManyToOne
  @JoinColumn(name = CATEGORY_ID, nullable = false)
  private Category category;

  private String description;

  public enum OrderStatus {
    DRAFT, PUBLISHED, IN_PROGRESS, RESOLVED, CLOSED
  }
}


