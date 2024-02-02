package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.entity.PostEntity;
import com.maxlvshv.pastebin.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @GetMapping("/posts")
    @Cacheable("posts")
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


