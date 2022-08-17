package org.profi.order.web.api;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.Type;
import org.profi.order.service.TypeService;
import org.profi.order.web.dto.TypeDto;
import org.profi.order.web.mapper.TypeMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@MeasurePerformance
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class TypeController {

  private final TypeService typeService;
  private final TypeMapper typeMapper;

  @GetMapping(value = "/type", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<TypeDto> getTypes() {
    List<Type> types = typeService.getAll();
    List<TypeDto> dtos = types.stream().map(typeMapper::typeToDto).collect(Collectors.toList());
    log.info("GetTypes request: " + dtos);
    return dtos;
  }

}
