package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.AcademicCycle;
import com.idat.neo.entrypoints.dto.AcademicCycleRequestDTO;
import com.idat.neo.entrypoints.dto.AcademicCycleResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademicCycleDtoMapper {

    AcademicCycle toDomain(AcademicCycleRequestDTO dto);

    AcademicCycleResponseDTO toDto(AcademicCycle academicCycle);
}
