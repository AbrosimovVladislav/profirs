package org.profi.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.time.LocalDateTime;

import static org.profi.order.model.Order.ORDER_ID;

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
    @JoinColumn(name = ORDER_ID)
    private Order order;
}
