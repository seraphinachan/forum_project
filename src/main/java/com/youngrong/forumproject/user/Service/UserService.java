package com.youngrong.forumproject.user.Service;

import com.youngrong.forumproject.user.DTO.UserDTO;
import com.youngrong.forumproject.user.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public String saveUser(UserDTO userDTO) {
        // 패스워드 암호화
        userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userRepository.save(userDTO.toEntity());
        return userDTO.getId();
    }
}
