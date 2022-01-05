package com.tqi_evolution_backend_2021.analisecred.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class LoginController {
    @RequestMapping("/")
    public String login(){
        return "login";
    }
}
