package org.profi.order.repo;

import java.util.Optional;
import org.profi.order.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {

  Optional<Customer> findByCustomerId(Long customerId);
}
