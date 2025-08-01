package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.ScheduledCourse;
import com.idat.neo.infrastructure.adapter.entity.ScheduledCourseData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduledCourseMapper {

    @Mapping(source = "courseData", target = "course")
    @Mapping(source = "userData", target = "user")
    @Mapping(source = "academicCycleData", target = "academicCycle")
    ScheduledCourse toDomain(ScheduledCourseData entity);

    @Mapping(source = "course", target = "courseData")
    @Mapping(source = "user", target = "userData")
    @Mapping(source = "academicCycle", target = "academicCycleData")
    ScheduledCourseData toEntity(ScheduledCourse domain);
}
