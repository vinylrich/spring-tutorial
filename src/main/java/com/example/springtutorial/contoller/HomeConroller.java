package com.example.springtutorial.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeConroller {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
