package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.ScheduledCourse;
import com.idat.neo.entrypoints.dto.ScheduledCourseRequestDTO;
import com.idat.neo.entrypoints.dto.ScheduledCourseResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduledCourseDtoMapper {

    ScheduledCourse toDomain(ScheduledCourseRequestDTO dto);

    ScheduledCourseResponseDTO toDto(ScheduledCourse scheduledCourse);
}
