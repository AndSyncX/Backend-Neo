package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Task;
import com.idat.neo.infrastructure.adapter.entity.TaskData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    @Mapping(source = "courseData", target = "course")
    Task toDomain(TaskData entity);

    @Mapping(source = "course", target = "courseData")
    TaskData toEntity(Task domain);
}
