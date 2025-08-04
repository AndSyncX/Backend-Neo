package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Career;
import com.idat.neo.entrypoints.dto.CareerRequestDTO;
import com.idat.neo.entrypoints.dto.CareerResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CareerDtoMapper {

    //@Mapping(source = "active", target = "active")
    Career toDomain(CareerRequestDTO dto);

    CareerResponseDTO toDto(Career career);
}
