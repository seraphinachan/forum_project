package com.youngrong.forumproject.user.Controller;

import com.youngrong.forumproject.user.DTO.UserDTO;
import com.youngrong.forumproject.user.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/user/save")
    public String saveUser(UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }
}
