package org.profi.order.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.profi.order.model.CategoryProperty;
import org.profi.order.model.Order;
import org.profi.order.repo.CategoryPropertyRepo;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryPropertiesService {

  private final CategoryPropertyRepo categoryPropertyRepo;


  public List<CategoryProperty> savePropertiesForOrder(Order order) {
    List<CategoryProperty> properties = order.getCategoryProperties().stream()
        .map(categoryProperty -> categoryProperty.setOrder(order))
        .collect(Collectors.toList());

    return categoryPropertyRepo.saveAll(properties);
  }
}
