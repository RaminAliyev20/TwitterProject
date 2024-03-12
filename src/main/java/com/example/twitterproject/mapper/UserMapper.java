package com.example.twitterproject.mapper;

import com.example.twitterproject.dao.entity.UserEntity;
import com.example.twitterproject.model.dto.UserDto;
import com.example.twitterproject.model.dto.requestDto.UserRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class UserMapper {
    public static final UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    public abstract UserEntity mapDtoToEntity(UserDto userDto);

    public abstract UserEntity mapRequestDtoToEntity(UserRequestDto userRequestDto);

    public abstract UserDto mapEntityToDto(UserEntity userEntity);

    public abstract List<UserDto> mapEntitiesToDtos(List<UserEntity> userEntityList);
}
