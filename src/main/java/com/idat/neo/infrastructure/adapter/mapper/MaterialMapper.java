package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Material;
import com.idat.neo.infrastructure.adapter.entity.MaterialData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    Material toDomain(MaterialData entity);
    MaterialData toEntity(Material domain);
}
