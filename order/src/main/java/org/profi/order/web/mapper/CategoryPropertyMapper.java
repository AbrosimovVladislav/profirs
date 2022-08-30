package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.profi.order.model.CategoryProperty;
import org.profi.order.web.dto.CategoryPropertyDto;
import org.springframework.stereotype.Component;

@Component
public class CategoryPropertyMapper {

  public List<CategoryPropertyDto> propertiesToDtos(List<CategoryProperty> categoryProperties) {
    return categoryProperties.stream().map(this::propertyToDto).collect(Collectors.toList());
  }

  public CategoryPropertyDto propertyToDto(CategoryProperty categoryProperty) {
    return CategoryPropertyDto.builder()
        .key(categoryProperty.getKey())
        .value(categoryProperty.getValues())
        .build();
  }
}
