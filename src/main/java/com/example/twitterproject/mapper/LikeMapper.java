package com.example.twitterproject.mapper;

import com.example.twitterproject.dao.entity.LikeEntity;
import com.example.twitterproject.dao.entity.TwitEntity;
import com.example.twitterproject.model.dto.LikeDto;
import com.example.twitterproject.model.dto.TwitDto;
import com.example.twitterproject.model.dto.requestDto.LikeRequestDto;
import com.example.twitterproject.model.dto.requestDto.TwitRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class LikeMapper {
    public static final LikeMapper INSTANCE = Mappers.getMapper(LikeMapper.class);

    public abstract LikeEntity mapDtoToEntity(LikeDto likeDto);

    public abstract LikeEntity mapRequestDtoToEntity(LikeRequestDto likeRequestDto);

    public abstract LikeDto mapEntityToDto(LikeEntity likeEntity);

    public abstract List<LikeDto> mapEntitiesToDto(List<LikeEntity> likeEntityList);
}
