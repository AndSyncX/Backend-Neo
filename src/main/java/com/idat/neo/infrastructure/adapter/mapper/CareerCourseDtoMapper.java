package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.CareerCourse;
import com.idat.neo.entrypoints.dto.CareerCourseRequestDTO;
import com.idat.neo.entrypoints.dto.CareerCourseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CareerCourseDtoMapper {

    CareerCourse toDomain(CareerCourseRequestDTO dto);

    @Mapping(source = "career.name", target = "nameCareer")
    @Mapping(source = "course.name", target = "nameCourse")
    @Mapping(expression = "java(careerCourse.active() ? \"Activo\" : \"Inactivo\")", target = "status")
    CareerCourseResponseDTO toDto(CareerCourse careerCourse);
}
