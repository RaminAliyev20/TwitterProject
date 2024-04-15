package com.example.twitterproject.dao.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String firstname;
    String lastname;
    String username;
    String phoneNumber;
    String email;
    String password;
    String gender;
    @Enumerated(EnumType.STRING)
    Role role;
    @CreationTimestamp
    LocalDateTime createdAt;
    @UpdateTimestamp
    LocalDateTime updatedAt;

    @JsonBackReference
    @OneToMany(mappedBy = "user")
    List<TwitEntity> twitEntityList;
    @JsonBackReference
    @OneToMany(mappedBy = "userEntity")
    List<LikeEntity> likeEntities;
    @JsonBackReference
    @OneToMany(mappedBy = "user")
    List<CommentEntity> commentEntities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
