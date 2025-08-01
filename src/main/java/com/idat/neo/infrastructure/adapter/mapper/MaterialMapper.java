package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Material;
import com.idat.neo.infrastructure.adapter.entity.MaterialData;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MaterialMapper {

   /* @Mapping(source = "courseData", target = "course")*/
    Material toDomain(MaterialData entity);

  /*  @Mapping(source = "course", target = "courseData")*/
    MaterialData toEntity(Material domain);
}
