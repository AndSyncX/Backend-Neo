package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.AssignmentDelivery;
import com.idat.neo.infrastructure.adapter.entity.AssignmentDeliveryData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignmentDeliveryMapper {
    AssignmentDelivery toDomain(AssignmentDeliveryData entity);
    AssignmentDeliveryData toEntity(AssignmentDelivery domain);
}
