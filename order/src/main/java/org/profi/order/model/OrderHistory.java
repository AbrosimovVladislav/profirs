package org.profi.order.model;

import static org.profi.order.model.Order.ORDER_ID;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
public class OrderHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long orderHistoryId;

  private LocalDateTime eventTime;

  @Enumerated(EnumType.STRING)
  private Order.OrderStatus source;
  @Enumerated(EnumType.STRING)
  private Order.OrderStatus target;
  private String payload;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name = ORDER_ID)
  private Order order;
}
