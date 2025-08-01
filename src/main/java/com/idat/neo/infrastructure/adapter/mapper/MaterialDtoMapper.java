package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Material;
import com.idat.neo.entrypoints.dto.MaterialRequestDTO;
import com.idat.neo.entrypoints.dto.MaterialResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MaterialDtoMapper {

    Material toDomain(MaterialRequestDTO dto);

   /* @Mapping(source = "course.name", target = "courseName")*/
    MaterialResponseDTO toDto(Material course);
}
