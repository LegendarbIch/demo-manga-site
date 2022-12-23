package com.example.demomangasite.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SingInController {
    @GetMapping("/singIn")
    public String getSingInPage() {
        return "singIn_page";
    }
}
