package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.entrypoints.dto.AssignmentDeliveryRequestDTO;
import com.idat.neo.entrypoints.dto.AssignmentDeliveryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentDeliveryDtoMapper {

    AssignmentDelivery toDomain(AssignmentDeliveryRequestDTO dto);

    @Mapping(source = "assignment.title", target = "assignmentTitle")
    @Mapping(source = "user.firstName", target = "userFirstName")
    @Mapping(source = "user.lastName", target = "userLastName")
    @Mapping(expression = "java(assignmentDelivery.active() ? \"Activo\" : \"Inactivo\")", target = "status")
    AssignmentDeliveryResponseDTO toDto(AssignmentDelivery assignmentDelivery);
}
