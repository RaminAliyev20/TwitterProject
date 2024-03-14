package com.example.twitterproject.service;

import com.example.twitterproject.dao.entity.LikeEntity;
import com.example.twitterproject.dao.repository.LikeRepository;
import com.example.twitterproject.mapper.LikeMapper;
import com.example.twitterproject.model.dto.LikeDto;
import com.example.twitterproject.model.dto.requestDto.LikeRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikeService {
    private final LikeRepository likeRepository;

    public List<LikeDto> getLikes() {
        log.info("ActionLog.getLikes start");
        List<LikeEntity> list = likeRepository.findAll();
        log.info("ActionLog.getLikes end");
        return LikeMapper.INSTANCE.mapEntitiesToDto(list);
    }

    public LikeDto getLike(Long id) {
        log.info("ActionLog.getLike start");
        LikeDto likeDto = LikeMapper.INSTANCE.mapEntityToDto(likeRepository.findById(id).get());
        log.info("ActionLog.getLike end");
        return likeDto;
    }

    public void addLike(LikeRequestDto likeRequestDto) {
        log.info("ActionLog.addLike start");
        likeRepository.save(LikeMapper.INSTANCE.mapRequestDtoToEntity(likeRequestDto));
        log.info("ActionLog.addLike end");
    }

    public void updateLike(Long id, LikeRequestDto likeRequestDto) {
        log.info("ActionLog.updateLike start");
        LikeEntity likeEntity = likeRepository.findById(id).get();
        BeanUtils.copyProperties(likeRequestDto, likeEntity, "id");
        log.info("ActionLog.updateLike end");
        likeRepository.save(likeEntity);
    }

    public void deleteLike(Long id) {
        log.info("ActionLog.deleteLike start");
        likeRepository.deleteById(id);
        log.info("ActionLog.deleteLike end");
    }
}
