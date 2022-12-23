package com.example.demomangasite.controllers;

import com.example.demomangasite.model.User;
import com.example.demomangasite.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UsersRepository usersRepository;


    @GetMapping("/users")
    public String getUsersPage(Model model) {
        List<User> users = usersRepository.findAll();
        model.addAttribute("users", users);
        return "users_page";
    }
}
