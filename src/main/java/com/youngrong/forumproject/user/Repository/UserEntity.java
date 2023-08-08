package com.youngrong.forumproject.user.Repository;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity(name = "USER_INFO")
@NoArgsConstructor
public class UserEntity {
    @Id
    private String userId;
    private String userPassword;
    private String userEmail;

    @Builder
    public UserEntity(
            String userId,
            String userPassword,
            String userEmail) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
    }
}
