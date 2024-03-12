package com.example.twitterproject.dao.repository;

import com.example.twitterproject.dao.entity.TwitEntity;
import com.example.twitterproject.dao.entity.UserEntity;
import com.example.twitterproject.model.dto.TwitDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TwitRepository extends JpaRepository<TwitEntity, Long> {
//    @Query("SELECT new com.example.twitterproject.model.dto.TwitDto(t.id, t.twit) FROM TwitEntity t")
//    List<TwitDto> findAllTwitDtos();
}
