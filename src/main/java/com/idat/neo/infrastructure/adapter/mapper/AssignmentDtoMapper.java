package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.entrypoints.dto.AssignmentRequestDTO;
import com.idat.neo.entrypoints.dto.AssignmentResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignmentDtoMapper {

    Assignment toDomain(AssignmentRequestDTO dto);

    AssignmentResponseDTO toDto(Assignment assignment);
}
