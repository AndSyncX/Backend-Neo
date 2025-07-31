package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.entrypoints.dto.AssignmentRequestDTO;
import com.idat.neo.entrypoints.dto.AssignmentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentDtoMapper {

    Assignment toDomain(AssignmentRequestDTO dto);

    @Mapping(source = "course.name", target = "courseName")
    AssignmentResponseDTO toDto(Assignment assignment);
}
