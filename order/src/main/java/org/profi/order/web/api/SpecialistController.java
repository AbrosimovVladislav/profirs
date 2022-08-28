package org.profi.order.web.api;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.profi.order.model.Specialist;
import org.profi.order.service.SpecialistService;
import org.profi.order.web.dto.SpecialistDto;
import org.profi.order.web.mapper.SpecialistMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
//@MeasurePerformance
@RequestMapping("api/v1/specialist")
@RequiredArgsConstructor
public class SpecialistController {

  private final SpecialistService specialistService;
  private final SpecialistMapper specialistMapper;

  @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<SpecialistDto> getSpecialists() {
    List<Specialist> specialists = specialistService.getAll();
    List<SpecialistDto> dtos = specialistMapper.specialistsToDtos(specialists);
    log.info("GetSpecialists request: " + dtos);
    return dtos;
  }

}
