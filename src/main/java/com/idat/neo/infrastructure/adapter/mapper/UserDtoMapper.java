package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.User;
import com.idat.neo.entrypoints.dto.UserRequestDTO;
import com.idat.neo.entrypoints.dto.UserResponseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    User toDomain(UserRequestDTO dto);

    @Mapping(expression = "java(user.active() ? \"Activo\" : \"Inactivo\")", target = "status")
    UserResponseDTO toDto(User user);
}
