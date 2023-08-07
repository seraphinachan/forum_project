package com.youngrong.forumproject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @RequestMapping("/join")
    public String join() {
        return "/join";
    }

    @GetMapping("/new")
    public String newPage() {
        return "new";
    }

    @GetMapping("/signUp")
    public String signUpPage() {
        return "signUp";
    }
}
