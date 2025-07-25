package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Material;
import com.idat.neo.domain.model.Course;
import com.idat.neo.entrypoints.dto.MaterialRequestDTO;
import com.idat.neo.entrypoints.dto.MaterialResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface MaterialDtoMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", source = "courseId", qualifiedByName = "mapCourse")
    Material toDomain(MaterialRequestDTO dto);

    @Mapping(source = "course.name", target = "courseName")
    MaterialResponseDTO toDto(Material course);

    @Named("mapCourse")
    default Course mapCourse(Long courseId) {
        return new Course(courseId, null, null, null,null,null);
    }
}
