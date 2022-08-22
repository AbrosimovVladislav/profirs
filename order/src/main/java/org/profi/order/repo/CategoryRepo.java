package org.profi.order.repo;

import java.util.Optional;
import org.profi.order.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {

  Optional<Category> findByShowName(String showName);
}
