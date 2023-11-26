package com.maxlvshv.pastebin.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class PostEntity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String subtitle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
