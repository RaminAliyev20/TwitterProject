package com.example.twitterproject.model.dto;

import com.example.twitterproject.dao.entity.CommentEntity;
import com.example.twitterproject.dao.entity.LikeEntity;
import com.example.twitterproject.dao.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties("user")
public class TwitDto {

    Long id;
    String twit;


    Long user_id;


//    List<Long> likesId;
//
//    List<Long> commentsId;
}
