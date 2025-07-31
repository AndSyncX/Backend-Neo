package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.AcademicCycle;
import com.idat.neo.infrastructure.adapter.entity.AcademicCycleData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AcademicCycleMapper {

    AcademicCycle toDomain(AcademicCycleData entity);

    AcademicCycleData toEntity(AcademicCycle domain);
}
