package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.infrastructure.adapter.entity.EnrollmentData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper {
    Enrollment toDomain(EnrollmentData entity);
    EnrollmentData toEntity(Enrollment domain);
}
