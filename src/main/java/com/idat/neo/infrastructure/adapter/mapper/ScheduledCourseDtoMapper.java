package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.ScheduledCourse;
import com.idat.neo.entrypoints.dto.ScheduledCourseRequestDTO;
import com.idat.neo.entrypoints.dto.ScheduledCourseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduledCourseDtoMapper {

    ScheduledCourse toDomain(ScheduledCourseRequestDTO dto);

    @Mapping(source = "course.name", target = "nameCourse")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(source = "academicCycle.name", target = "nameAcademicCycle")
    ScheduledCourseResponseDTO toDto(ScheduledCourse scheduledCourse);
}
