package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.entity.PostEntity;
import com.maxlvshv.pastebin.service.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostServiceImpl postService;

    @GetMapping
    @Cacheable("posts")
    public ResponseEntity<?> showAllPostsTest() {
        try {
            return ResponseEntity.ok(postService.showAllPosts());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Can't download posts");
        }
    }

    @PostMapping("/{name}/create")
    public ResponseEntity<?> createPost(@RequestBody PostEntity post, @PathVariable("name") String name) {
        try {
            postService.addPosts(post, name);
            return ResponseEntity.ok("post is created");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("can't create post");
        }
    }
}


