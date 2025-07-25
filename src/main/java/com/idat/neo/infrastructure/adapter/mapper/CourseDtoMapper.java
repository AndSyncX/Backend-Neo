package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.Course;
import com.idat.neo.domain.model.User;
import com.idat.neo.entrypoints.dto.CourseRequestDTO;
import com.idat.neo.entrypoints.dto.CourseResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface CourseDtoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUser")
    Course toDomain(CourseRequestDTO dto);

    @Mapping(source = "user.name", target = "userFullName")
    CourseResponseDTO toDto(Course course);

    @Named("mapUser")
    default User mapUser(String userId) {
        return new User(userId, null, null, null,null,false);
    }
}
