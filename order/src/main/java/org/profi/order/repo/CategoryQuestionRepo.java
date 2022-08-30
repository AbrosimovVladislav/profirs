package org.profi.order.repo;

import java.util.List;
import org.profi.order.model.Category;
import org.profi.order.model.CategoryQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryQuestionRepo extends JpaRepository<CategoryQuestion, Long> {

  List<CategoryQuestion> findByCategory(Category category);

}
