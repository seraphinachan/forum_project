package com.youngrong.forumproject.user.DTO;

import com.youngrong.forumproject.user.Repository.UserEntity;
import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String password;
    private String email;

    public UserEntity toEntity() {
        return UserEntity.builder()
                .userId(id)
                .userPassword(password)
                .userEmail(email)
                .build();
    }
}
