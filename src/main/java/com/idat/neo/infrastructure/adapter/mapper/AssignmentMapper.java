package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Assignment;
import com.idat.neo.infrastructure.adapter.entity.AssignmentData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssignmentMapper {

    Assignment toDomain(AssignmentData entity);

    AssignmentData toEntity(Assignment domain);
}
