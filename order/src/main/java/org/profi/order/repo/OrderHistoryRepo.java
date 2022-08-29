package org.profi.order.repo;

import java.util.List;
import org.profi.order.model.Order;
import org.profi.order.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Long> {

  List<OrderHistory> findByOrder(Order order);

}
