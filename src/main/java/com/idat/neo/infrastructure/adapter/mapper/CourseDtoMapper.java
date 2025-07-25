package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Course;
import com.idat.neo.entrypoints.dto.CourseRequestDTO;
import com.idat.neo.entrypoints.dto.CourseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CourseDtoMapper {

    Course toDomain(CourseRequestDTO dto);

    @Mapping(source = "user.name", target = "userFullName")
    CourseResponseDTO toDto(Course course);
}
