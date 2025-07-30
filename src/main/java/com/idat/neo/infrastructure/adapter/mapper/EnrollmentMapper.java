package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.infrastructure.adapter.entity.EnrollmentData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {

    @Mapping(source = "courseData", target = "course")
    @Mapping(source = "userData", target = "user")
    Enrollment toDomain(EnrollmentData entity);

    @Mapping(source = "course", target = "courseData")
    @Mapping(source = "user", target = "userData")
    EnrollmentData toEntity(Enrollment domain);
}
