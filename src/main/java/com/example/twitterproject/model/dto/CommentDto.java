package com.example.twitterproject.model.dto;

import com.example.twitterproject.dao.entity.TwitEntity;
import com.example.twitterproject.dao.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CommentDto {

    Long id;
    String comment;

    Long twit_id;

    Long user_id;
}
