package org.edu.demo1.api.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login-view")
    public String login() {
        return "/login/login";
    }

}
