package com.example.twitterproject.service;

import com.example.twitterproject.dao.entity.UserEntity;
import com.example.twitterproject.dao.repository.UserRepository;
import com.example.twitterproject.mapper.UserMapper;
import com.example.twitterproject.model.dto.UserDto;
import com.example.twitterproject.model.dto.requestDto.UserRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public List<UserDto> getUsers() {
        log.info("ActionLog.getUsers start");
        List<UserEntity> list = userRepository.findAll();
        log.info("ActionLog.getUsers end");
        return UserMapper.INSTANCE.mapEntitiesToDtos(list);
    }

    public UserDto getUser(Long id) {
        log.info("ActionLog.getUser start");
        UserDto userDto = UserMapper.INSTANCE.mapEntityToDto(userRepository.findById(id).get());
        log.info("ActionLog.getUser end");
        return userDto;
    }

    public void addUser(UserRequestDto userRequestDto) {
        log.info("ActionLog.addUsers start");
        userRepository.save(UserMapper.INSTANCE.mapRequestDtoToEntity(userRequestDto));
        log.info("ActionLog.addUsers end");
    }

    public void updateUser(Long id, UserRequestDto userRequestDto) {
        log.info("ActionLog.updateUser start");
        UserEntity userEntity = userRepository.findById(id).get();
        BeanUtils.copyProperties(userRequestDto, userEntity, "id");
        userRepository.save(userEntity);
        log.info("ActionLog.updateUser end");
    }

    public void deleteUser(Long id) {
        log.info("ActionLog.deleteUser start");
        userRepository.deleteById(id);
        log.info("ActionLog.deleteUser end");
    }

}
