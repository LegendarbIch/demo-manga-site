package com.example.demomangasite.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "account",
       uniqueConstraints = {
                        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
       })
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(
            name = "nickname",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String nickname;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String email;

    @Column(
            name = "hash_Password",
            nullable = false
    )
    private String hashPassword;
    @Transient
    private String password;


}
