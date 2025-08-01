package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.CareerCourse;
import com.idat.neo.infrastructure.adapter.entity.CareerCourseData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CareerCourseMapper {

    @Mapping(source = "careerData", target = "career")
    @Mapping(source = "courseData", target = "course")
    CareerCourse toDomain(CareerCourseData entity);

    @Mapping(source = "career", target = "careerData")
    @Mapping(source = "course", target = "courseData")
    CareerCourseData toEntity(CareerCourse domain);
}
