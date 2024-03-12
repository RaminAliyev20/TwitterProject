package com.example.twitterproject.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String username;
    String password;
    String firstname;
    String lastname;
    String gender;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    List<TwitEntity> twitEntityList;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userEntity")
    List<LikeEntity> likeEntities;
    @JsonBackReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<CommentEntity> commentEntities;
}
