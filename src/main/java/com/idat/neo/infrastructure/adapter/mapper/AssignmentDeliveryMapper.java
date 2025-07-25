package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.infrastructure.adapter.entity.AssignmentDeliveryData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AssignmentDeliveryMapper {

    @Mapping(source = "taskData", target = "task")
    @Mapping(source = "userData", target = "user")
    AssignmentDelivery toDomain(AssignmentDeliveryData entity);

    @Mapping(source = "task", target = "taskData")
    @Mapping(source = "user", target = "userData")
    AssignmentDeliveryData toEntity(AssignmentDelivery domain);
}
