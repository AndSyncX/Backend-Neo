package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.infrastructure.adapter.entity.EnrollmentData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(source = "scheduledCourseData", target = "scheduledCourse")
    @Mapping(source = "userData", target = "user")
    Enrollment toDomain(EnrollmentData entity);

    @Mapping(source = "scheduledCourse", target = "scheduledCourseData")
    @Mapping(source = "user", target = "userData")
    EnrollmentData toEntity(Enrollment domain);
}
