package com.maxlvshv.pastebin.service;

import com.maxlvshv.pastebin.entity.PostEntity;
import com.maxlvshv.pastebin.exceptions.UserIsNotExistException;

import java.util.List;

public interface PostService {
    boolean userIsExist(String name);

    void addPosts(PostEntity post, String name) throws UserIsNotExistException;

    List<PostEntity> showAllPosts();
}
