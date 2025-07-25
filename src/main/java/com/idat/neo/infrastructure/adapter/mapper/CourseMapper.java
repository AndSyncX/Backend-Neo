package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Course;
import com.idat.neo.infrastructure.adapter.entity.CourseData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface CourseMapper {

    @Mapping(source = "userData", target = "user")
    Course toDomain(CourseData entity);

    @Mapping(source = "user", target = "userData")
    CourseData toEntity(Course domain);
}
