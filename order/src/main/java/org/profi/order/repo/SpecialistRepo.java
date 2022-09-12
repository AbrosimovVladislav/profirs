package org.profi.order.repo;

import java.util.List;
import java.util.Optional;

import org.profi.order.model.Category;
import org.profi.order.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepo extends JpaRepository<Specialist, Long> {

  Optional<Specialist> findBySpecialistId(Long specialistId);
  List<Specialist> findByCategory(Category category);
}
