package com.example.twitterproject.service;

import com.example.twitterproject.dao.entity.TwitEntity;
import com.example.twitterproject.dao.repository.TwitRepository;
import com.example.twitterproject.mapper.TwitMapper;
import com.example.twitterproject.model.dto.TwitDto;
import com.example.twitterproject.model.dto.requestDto.TwitRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TwitService {
    private final TwitRepository twitRepository;

    public List<TwitDto> getTwits() {
        log.info("ActionLog.getTwits start");
        List<TwitEntity> list = twitRepository.findAll();
        log.info("ActionLog.getTwits end");
        return TwitMapper.INSTANCE.mapEntitiesToDto(list);
    }

    public void addTwit(TwitRequestDto twitRequestDto) {
        log.info("ActionLog.addTwit start");
        twitRepository.save(TwitMapper.INSTANCE.mapRequestDtoToEntity(twitRequestDto));
        log.info("ActionLog.addTwits end");
    }

    public TwitDto getTwit(Long id) {
        log.info("ActionLog.getTwit start");
        TwitDto twitDto = TwitMapper.INSTANCE.mapEntityToDto(twitRepository.findById(id).get());
        log.info("ActionLog.getTwit end");
        return twitDto;
    }

    public void updateTwit(Long id, TwitRequestDto twitRequestDto) {
        log.info("ActionLog.updateTwit start");
        TwitEntity twitEntity = twitRepository.findById(id).get();
        BeanUtils.copyProperties(twitRequestDto, twitEntity, "id");
        twitRepository.save(twitEntity);
        log.info("ActionLog.updateTwit end");
    }

    public void deleteTwit(Long id) {
        log.info("ActionLog.deleteTwit start");
        twitRepository.deleteById(id);
        log.info("ActionLog.deleteTwit end");
    }
}
