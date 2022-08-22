package org.profi.order.web.api;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.Category;
import org.profi.order.service.CategoryService;
import org.profi.order.web.dto.CategoryDto;
import org.profi.order.web.mapper.CategoryMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@MeasurePerformance
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class CategoryController {

  private final CategoryService categoryService;
  private final CategoryMapper categoryMapper;

  @GetMapping(value = "/category", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<CategoryDto> getCategories() {
    List<Category> categories = categoryService.getAll();
    List<CategoryDto> dtos = categories.stream().map(categoryMapper::categoryToDto)
        .collect(Collectors.toList());
    log.info("GetCategories request: " + dtos);
    return dtos;
  }

}
