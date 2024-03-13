package com.example.twitterproject.model.dto;

import com.example.twitterproject.dao.entity.CommentEntity;
import com.example.twitterproject.dao.entity.LikeEntity;
import com.example.twitterproject.dao.entity.TwitEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserDto {

    Long id;
    String username;
    String password;
    String firstname;
    String lastname;
    String gender;

    List<TwitEntity> twitEntityList;

    List<LikeDto> likeDtos;

    List<CommentDto> commentDtos;

}
