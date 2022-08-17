package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.profi.order.model.Type;
import org.profi.order.web.dto.TypeDto;
import org.springframework.stereotype.Component;

@Component
public class TypeMapper {

  public List<TypeDto> typesToDtos(List<Type> types) {
    return types.stream().map(this::typeToDto).collect(Collectors.toList());
  }

  public TypeDto typeToDto(Type type) {
    return TypeDto.builder()
        .name(type.getName())
        .build();
  }
}
