package com.maxlvshv.pastebin.model;

import com.maxlvshv.pastebin.entity.UserEntity;
import lombok.Data;

@Data
public class User {
    private String nickname;

    private String email;

    public static User toModel(UserEntity userEntity) {
        User model = new User();
        model.setNickname(userEntity.getNickname());
        model.setEmail(userEntity.getEmail());

        return model;
    }
}
