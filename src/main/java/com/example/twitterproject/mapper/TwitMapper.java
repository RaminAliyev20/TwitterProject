package com.example.twitterproject.mapper;

import com.example.twitterproject.dao.entity.TwitEntity;
import com.example.twitterproject.model.dto.TwitDto;
import com.example.twitterproject.model.dto.requestDto.TwitRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class TwitMapper {
    public static final TwitMapper INSTANCE = Mappers.getMapper(TwitMapper.class);

    public abstract TwitEntity mapDtoToEntity(TwitDto twitDto);
    @Mapping(target = "user.id", source = "user_id")
    public abstract TwitEntity mapRequestDtoToEntity(TwitRequestDto twitRequestDto);

    public abstract TwitDto mapEntityToDto(TwitEntity twitEntity);

    public abstract List<TwitDto> mapEntitiesToDto(List<TwitEntity> twitEntityList);

}
