package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.infrastructure.adapter.entity.AssignmentData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    @Mapping(source = "courseData", target = "course")
    Assignment toDomain(AssignmentData entity);

    @Mapping(source = "course", target = "courseData")
    AssignmentData toEntity(Assignment domain);
}
