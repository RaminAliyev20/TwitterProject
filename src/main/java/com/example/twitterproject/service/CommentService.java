package com.example.twitterproject.service;

import com.example.twitterproject.dao.entity.CommentEntity;
import com.example.twitterproject.dao.repository.CommentRepository;
import com.example.twitterproject.mapper.CommentMapper;
import com.example.twitterproject.model.dto.CommentDto;
import com.example.twitterproject.model.dto.requestDto.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {
    private final CommentRepository commentRepository;

    public List<CommentDto> getComments() {
        log.info("ActionLog.getComments start");
        List<CommentEntity> list = commentRepository.findAll();
        log.info("ActionLog.getComments end");
        return CommentMapper.INSTANCE.mapEntitiesToDto(list);
    }

    public CommentDto getComment(Long id) {
        log.info("ActionLog.getComment start");
        CommentEntity commentEntity = commentRepository.findById(id).get();
        log.info("ActionLog.getComment end");
        return CommentMapper.INSTANCE.mapEntityToDto(commentEntity);
    }

    public void addComment(CommentRequestDto commentRequestDto) {
        log.info("ActionLog.addComment start");
        commentRepository.save(CommentMapper.INSTANCE.mapRequestDtoToEntity(commentRequestDto));
        log.info("ActionLog.addComment end");
    }

    public void updateComment(Long id, CommentRequestDto commentRequestDto) {
        log.info("ActionLog.updateComment start");
        CommentEntity commentEntity = commentRepository.findById(id).get();
        BeanUtils.copyProperties(commentRequestDto, commentEntity, "id");
        commentRepository.save(commentEntity);
        log.info("ActionLog.updateComment end");
    }

    public void deleteComment(Long id) {
        log.info("ActionLog.deleteComment start");
        commentRepository.deleteById(id);
        log.info("ActionLog.deleteComment end");
    }
}
