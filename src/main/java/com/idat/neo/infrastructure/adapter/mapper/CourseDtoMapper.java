package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Course;
import com.idat.neo.entrypoints.dto.CourseRequestDTO;
import com.idat.neo.entrypoints.dto.CourseResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseDtoMapper {

    Course toDomain(CourseRequestDTO dto);

    CourseResponseDTO toDto(Course course);
}
