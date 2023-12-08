package com.maxlvshv.pastebin.entity;


import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("feedback")
@Data
public class Feedback {
    @Id
    private Long id;

    private String title;
}
