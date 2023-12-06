package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.entity.PostEntity;
import com.maxlvshv.pastebin.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@EnableCaching
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    @Cacheable(key = "", value = "Posts")
    public ResponseEntity<?> showAllPostsTest() {
        try {
            return ResponseEntity.ok(postService.showAllPostsTest());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("can't snow ur posts");
        }
    }

    @PostMapping("/{nickname}/create")
    public ResponseEntity<?> createPost(@RequestBody PostEntity post, @PathVariable("nickname") String nickname) {
        try {
            postService.addPosts(post, nickname);
            return ResponseEntity.ok("post is created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("can't create post");
        }
    }
}


