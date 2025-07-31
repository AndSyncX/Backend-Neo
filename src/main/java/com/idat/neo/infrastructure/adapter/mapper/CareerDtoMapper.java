package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Career;
import com.idat.neo.entrypoints.dto.CareerRequestDTO;
import com.idat.neo.entrypoints.dto.CareerResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CareerDtoMapper {

    Career toDomain(CareerRequestDTO dto);

    CareerResponseDTO toDto(Career career);
}
