package org.profi.order.web.mapper;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.profi.order.model.Specialist;
import org.profi.order.web.dto.SpecialistDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SpecialistMapper {

  public List<SpecialistDto> specialistsToDtos(List<Specialist> specialists) {
    return specialists.stream().map(this::specialistToDto).collect(Collectors.toList());
  }

  public SpecialistDto specialistToDto(Specialist specialist) {
    return SpecialistDto.builder()
        .specialistId(specialist.getSpecialistId())
        .personId(specialist.getPerson().getPersonId())
        .name(specialist.getPerson().getName())
        .build();
  }
}
