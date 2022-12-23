package com.example.demomangasite.repositories;

import com.example.demomangasite.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

}
