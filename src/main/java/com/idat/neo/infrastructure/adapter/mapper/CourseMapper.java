package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Course;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper {

    Course toDomain(CourseData entity);

    CourseData toEntity(Course domain);
}
