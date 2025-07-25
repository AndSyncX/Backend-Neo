package com.idat.neo.infrastructure.adapter.mapper;

import com.idat.neo.domain.model.User;
import com.idat.neo.infrastructure.adapter.entity.UserData;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toDomain(UserData entity);

    UserData toEntity(User domain);
}
