package org.profi.order.web.mapper;

import org.springframework.stereotype.Component;

@Component
public class LinksCreator {

  public String createCategoryLink(String categoryShowName) {
    categoryShowName = categoryShowName.toLowerCase();
    categoryShowName = categoryShowName.replaceAll(" ", "-");
    return "/categories/" + categoryShowName;
  }

}
