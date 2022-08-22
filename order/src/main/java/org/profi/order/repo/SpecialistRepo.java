package org.profi.order.repo;

import java.util.Optional;
import org.profi.order.model.Specialist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialistRepo extends JpaRepository<Specialist, Long> {

  Optional<Specialist> findBySpecialistId(Long specialistId);
}
