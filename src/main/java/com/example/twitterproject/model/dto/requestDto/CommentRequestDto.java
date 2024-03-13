package com.example.twitterproject.model.dto.requestDto;

import com.example.twitterproject.dao.entity.TwitEntity;
import com.example.twitterproject.dao.entity.UserEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CommentRequestDto {
    String comment;

    Long twit_id;

    Long user_id;
}
