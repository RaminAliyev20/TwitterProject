package com.example.twitterproject.mapper;

import com.example.twitterproject.dao.entity.CommentEntity;
import com.example.twitterproject.dao.entity.TwitEntity;
import com.example.twitterproject.model.dto.CommentDto;
import com.example.twitterproject.model.dto.TwitDto;
import com.example.twitterproject.model.dto.requestDto.CommentRequestDto;
import com.example.twitterproject.model.dto.requestDto.TwitRequestDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class CommentMapper {
    public static final CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    public abstract CommentEntity mapDtoToEntity(CommentDto commentDto);
    @Mapping(target = "user.id", source = "user_id")
    @Mapping(target = "twitEntity.id", source = "twit_id")
    public abstract CommentEntity mapRequestDtoToEntity(CommentRequestDto commentRequestDto);
    @Mapping(target = "user_id",source = "user.id")
    @Mapping(target = "twit_id", source = "twitEntity.id")
    public abstract CommentDto mapEntityToDto(CommentEntity commentEntity);

    public abstract List<CommentDto> mapEntitiesToDto(List<CommentEntity> commentEntityList);
}
