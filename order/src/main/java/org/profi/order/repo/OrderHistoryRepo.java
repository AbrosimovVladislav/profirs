package org.profi.order.repo;

import org.profi.order.model.OrderHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderHistoryRepo extends JpaRepository<OrderHistory, Long> {
}
