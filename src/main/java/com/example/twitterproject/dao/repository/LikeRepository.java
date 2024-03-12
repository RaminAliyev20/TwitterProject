package com.example.twitterproject.dao.repository;

import com.example.twitterproject.dao.entity.LikeEntity;
import com.example.twitterproject.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, Long> {
}
