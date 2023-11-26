package com.maxlvshv.pastebin.model;

import com.maxlvshv.pastebin.entity.UserEntity;
import lombok.Data;

@Data
public class UserPassword {
    private String nickname;

    private String password;

    public static UserPassword toModel(UserEntity userEntity) {
        UserPassword model = new UserPassword();
        model.setNickname(userEntity.getNickname());
        model.setPassword(userEntity.getPassword());

        return model;
    }
}
