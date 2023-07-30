package com.youngrong.forumproject.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {
    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/new")
    public String newPage() {
        return "new";
    }
}
