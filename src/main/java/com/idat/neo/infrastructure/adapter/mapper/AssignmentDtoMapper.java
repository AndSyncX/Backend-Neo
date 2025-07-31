package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.entrypoints.dto.TaskRequestDTO;
import com.idat.neo.entrypoints.dto.TaskResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentDtoMapper {

    Assignment toDomain(TaskRequestDTO dto);

    @Mapping(source = "course.name", target = "courseName")
    TaskResponseDTO toDto(Assignment assignment);
}
