package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.entrypoints.dto.AssignmentDeliveryRequestDTO;
import com.idat.neo.entrypoints.dto.AssignmentDeliveryResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentDeliveryDtoMapper {

    AssignmentDelivery toDomain(AssignmentDeliveryRequestDTO dto);

    @Mapping(source = "task.title", target = "taskTitle")
    @Mapping(source = "user.name", target = "userFullName")
    AssignmentDeliveryResponseDTO toDto(AssignmentDelivery delivery);
}
