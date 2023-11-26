package com.maxlvshv.pastebin.service;

import com.maxlvshv.pastebin.entity.PostEntity;
import com.maxlvshv.pastebin.entity.UserEntity;
import com.maxlvshv.pastebin.exceptions.UserIsNotExistException;
import com.maxlvshv.pastebin.repository.PostRepo;
import com.maxlvshv.pastebin.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    @Autowired
    public PostService(PostRepo postRepo, UserRepo userRepo) {
        this.postRepo = postRepo;
        this.userRepo = userRepo;
    }

    public boolean userIsExist(String name) {
        for (UserEntity el : userRepo.findAll()) {
            if (el.getNickname().equals(name))
                return true;
        }
        return false;
    }

    public void addPosts(PostEntity post, String nickname) throws UserIsNotExistException {
        if (userIsExist(nickname)) {
            UserEntity user = userRepo.findByNickname(nickname);
            post.setUser(user);
            postRepo.save(post);
        } else {
            throw new UserIsNotExistException("Can't find user");
        }
    }


    public List<PostEntity> showAllPosts() {
        return postRepo.findAll();
    }
}
