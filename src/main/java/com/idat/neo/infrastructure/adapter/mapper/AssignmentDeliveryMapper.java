package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.infrastructure.adapter.entity.AssignmentDeliveryData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentDeliveryMapper {

    @Mapping(source = "assignmentData", target = "assignment")
    @Mapping(source = "userData", target = "user")
    AssignmentDelivery toDomain(AssignmentDeliveryData entity);

    @Mapping(source = "assignment", target = "assignmentData")
    @Mapping(source = "user", target = "userData")
    AssignmentDeliveryData toEntity(AssignmentDelivery domain);
}
