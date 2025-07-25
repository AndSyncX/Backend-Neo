package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Task;
import com.idat.neo.domain.model.Course;
import com.idat.neo.entrypoints.dto.TaskRequestDTO;
import com.idat.neo.entrypoints.dto.TaskResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "course", source = "courseId", qualifiedByName = "mapCourse")
    Task toDomain(TaskRequestDTO dto);

    @Mapping(source = "course.name", target = "courseName")
    TaskResponseDTO toDto(Task course);

    @Named("mapCourse")
    default Course mapCourse(Long courseId) {
        return new Course(courseId, null, null, null,null,null);
    }
}
