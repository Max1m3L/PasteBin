package com.maxlvshv.pastebin.service;

import com.maxlvshv.pastebin.entity.UserEntity;
import com.maxlvshv.pastebin.exceptions.UserAlreadyExistException;
import com.maxlvshv.pastebin.model.User;
import com.maxlvshv.pastebin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User showOneUser(String nickname) {
        return User.toModel(userRepo.findByNickname(nickname));
    }

    public List<User> showUsers() {
        List<UserEntity> userEntities = userRepo.findAll();
        List<User> usersModel = new ArrayList<>();
        for (UserEntity el : userEntities)
            usersModel.add(User.toModel(el));
        return usersModel;
    }

    public void addUser(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByNickname(user.getNickname()) != null)
            throw new UserAlreadyExistException("Nickname already exist");
        userRepo.save(user);
    }

    public boolean authorizedName(String nickname) {
        for (UserEntity el : userRepo.findAll()) {
            if (Objects.equals(el.getNickname(), nickname))
                return true;
        }
        return false;
    }
    public boolean authorizedPassword(String password) {
        for (UserEntity el : userRepo.findAll()) {
            if (Objects.equals(el.getPassword(), password))
                return true;
        }
        return false;
    }

//    public List<PostEntity> getUserPost(String nickname) {
//        return userRepo.findByNickname(nickname);
//    }
}
