package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Career;
import com.idat.neo.infrastructure.adapter.entity.CareerData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CareerMapper {

    Career toDomain(CareerData entity);

    CareerData toEntity(Career domain);
}
