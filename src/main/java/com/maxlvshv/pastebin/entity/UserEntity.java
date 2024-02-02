package com.maxlvshv.pastebin.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nickname;

    private String email;

    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<PostEntity> posts;

    private String Role;
}
