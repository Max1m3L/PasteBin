package com.maxlvshv.pastebin.service;

import com.maxlvshv.pastebin.entity.UserEntity;
import com.maxlvshv.pastebin.exceptions.UserAlreadyExistException;
import com.maxlvshv.pastebin.model.User;
import com.maxlvshv.pastebin.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userRepo.save(user);
    }

//    I'LL DO IT LATER
//    public List<Post> getUserPosts() {
//        List<PostEntity> postEntities = postRepo.findAll();
//        List<Post> posts = new ArrayList<>();
//        for (PostEntity el : postEntities) {
//            posts.add(Post.toModel(el));
//        }
//        return posts;
//    }
}
