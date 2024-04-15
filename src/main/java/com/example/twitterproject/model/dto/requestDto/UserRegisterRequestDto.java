package com.example.twitterproject.model.dto.requestDto;

import lombok.*;
import lombok.experimental.FieldDefaults;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRegisterRequestDto {
    String firstname;
    String lastname;
    String username;
    String phoneNumber;
    String email;
    String password;

}
