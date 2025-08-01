package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.ScheduledCourse;
import com.idat.neo.infrastructure.adapter.entity.ScheduledCourseData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ScheduledCourseMapper {

    ScheduledCourse toDomain(ScheduledCourseData entity);

    ScheduledCourseData toEntity(ScheduledCourse domain);
}
