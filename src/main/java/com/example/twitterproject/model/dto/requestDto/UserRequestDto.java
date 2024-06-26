package com.example.twitterproject.model.dto.requestDto;

import com.example.twitterproject.dao.entity.CommentEntity;
import com.example.twitterproject.dao.entity.LikeEntity;
import com.example.twitterproject.dao.entity.TwitEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequestDto {
    String firstname;
    String lastname;
    String username;
    String phoneNumber;
    String email;
    String password;
    String gender;

}
