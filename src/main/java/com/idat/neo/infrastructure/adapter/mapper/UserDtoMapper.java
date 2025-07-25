package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.User;
import com.idat.neo.entrypoints.dto.UserRequestDTO;
import com.idat.neo.entrypoints.dto.UserResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserDtoMapper {

    User toDomain(UserRequestDTO dto);

    UserResponseDTO toDto(User user);
}
