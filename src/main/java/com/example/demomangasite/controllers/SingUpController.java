package com.example.demomangasite.controllers;

import com.example.demomangasite.model.User;
import com.example.demomangasite.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SingUpController {
    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/singUp")
    public String getSingUpPage(){
        return "singup_page";
    }

    @PostMapping("/singUp")
    public String singUpUser(User user) {
        user.setHashPassword(passwordEncoder.encode(user.getPassword()));
        usersRepository.save(user);
        return "redirect:/singUp";
    }
}
