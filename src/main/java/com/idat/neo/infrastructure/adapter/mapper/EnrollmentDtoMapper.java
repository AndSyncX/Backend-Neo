package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Enrollment;
import com.idat.neo.entrypoints.dto.EnrollmentRequestDTO;
import com.idat.neo.entrypoints.dto.EnrollmentResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnrollmentDtoMapper {

    Enrollment toDomain(EnrollmentRequestDTO dto);

    @Mapping(source = "scheduledCourse.course.name", target = "courseName")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    EnrollmentResponseDTO toDto(Enrollment enrollment);
}
