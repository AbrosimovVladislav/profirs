package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.profi.order.model.Category;
import org.profi.order.web.dto.CategoryDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {

  public List<CategoryDto> categoriesToDtos(List<Category> categories) {
    return categories.stream().map(this::categoryToDto).collect(Collectors.toList());
  }

  public CategoryDto categoryToDto(Category category) {
    return CategoryDto.builder()
        .categoryId(category.getCategoryId())
        .firstLevel(category.getFirstLevel())
        .secondLevel(category.getSecondLevel())
        .thirdLevel(category.getThirdLevel())
        .showName(category.getShowName())
        .build();
  }
}
