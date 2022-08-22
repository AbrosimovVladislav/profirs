package org.profi.order.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.exception.CustomerNotFoundException;
import org.profi.order.model.Customer;
import org.profi.order.repo.CustomerRepo;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerService {

  private final CustomerRepo customerRepo;

  public Customer findById(Long customerId) {
    return customerRepo.findById(customerId)
        .orElseThrow(() -> new CustomerNotFoundException(customerId));
  }
}
