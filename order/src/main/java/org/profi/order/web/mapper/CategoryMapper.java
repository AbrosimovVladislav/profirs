package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.profi.order.model.Category;
import org.profi.order.web.dto.CategoryDto;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

  private final LinksCreator linksCreator;

  public List<CategoryDto> categoriesToDtosTree(List<Category> categories) {
    List<Category> firstLvlCategories = categories.stream()
        .filter(category -> category.getSecondLevel() == null && category.getThirdLevel() == null)
        .toList();

    return firstLvlCategories.stream()
        .map(firstLvlCategory -> {
          List<CategoryDto> secondLvlCategories = categories.stream()
              .filter(category ->
                  category.getFirstLevel().equals(firstLvlCategory.getFirstLevel())
                      && category.getSecondLevel() != null
                      && category.getThirdLevel() == null)
              .map(secondLvlCategory -> categoryToDto(secondLvlCategory, null))
              .toList();
          return Pair.of(firstLvlCategory, secondLvlCategories);
        })
        .map(pair -> categoryToDto(pair.getFirst(), pair.getSecond()))
        .collect(Collectors.toList());
  }

  public CategoryDto categoryToDto(Category category,
      List<CategoryDto> children) {
    return CategoryDto.builder()
        .id(category.getCategoryId())
        .firstLevel(category.getFirstLevel())
        .secondLevel(category.getSecondLevel())
        .thirdLevel(category.getThirdLevel())
        .title(category.getShowName())
        .link(linksCreator.createCategoryLink(category.getShowName()))
        .children(children)
        .build();
  }
}
