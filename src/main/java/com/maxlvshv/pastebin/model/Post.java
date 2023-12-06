package com.maxlvshv.pastebin.model;

import com.maxlvshv.pastebin.entity.PostEntity;
import lombok.Data;

@Data
public class Post {
    private String title;

    private String subtitle;

    public static Post toModel(PostEntity post) {
        Post model = new Post();
        model.setTitle(post.getTitle());
        model.setSubtitle(post.getSubtitle());
        return model;
    }
}
