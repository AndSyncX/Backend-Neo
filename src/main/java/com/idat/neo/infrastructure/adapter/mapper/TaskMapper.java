package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Task;
import com.idat.neo.infrastructure.adapter.entity.TaskData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task toDomain(TaskData entity);
    TaskData toEntity(Task domain);
}
