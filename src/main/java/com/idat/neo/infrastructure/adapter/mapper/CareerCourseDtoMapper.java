package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.CareerCourse;
import com.idat.neo.entrypoints.dto.CareerCourseRequestDTO;
import com.idat.neo.entrypoints.dto.CareerCourseResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CareerCourseDtoMapper {

    CareerCourse toDomain(CareerCourseRequestDTO dto);

    CareerCourseResponseDTO toDto(CareerCourse careerCourse);
}
