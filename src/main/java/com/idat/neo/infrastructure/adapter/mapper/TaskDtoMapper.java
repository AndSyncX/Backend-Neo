package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Task;
import com.idat.neo.entrypoints.dto.TaskRequestDTO;
import com.idat.neo.entrypoints.dto.TaskResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {

    Task toDomain(TaskRequestDTO dto);

    @Mapping(source = "course.name", target = "courseName")
    TaskResponseDTO toDto(Task task);
}
