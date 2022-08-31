package org.profi.order.repo;

import java.util.List;
import org.profi.order.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryQuestionRepo extends JpaRepository<Question, Long> {

  @Query(
      value = "SELECT * FROM question q JOIN category_question cq on q.question_id = cq.question_id WHERE cq.category_id = ?1",
      nativeQuery = true)
  List<Question> findByCategory(Long categoryId);

}
