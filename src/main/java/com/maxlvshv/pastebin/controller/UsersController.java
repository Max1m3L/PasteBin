package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {
    private final UserService userService;

    @GetMapping
    @Cacheable("users")
    public ResponseEntity<?> showAll() {
        return ResponseEntity.ok(userService.showUsers());
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<?> showUser(@PathVariable("nickname") String nickname) {
        return ResponseEntity.ok(userService.showOneUser(nickname));
    }

//     I'LL DO IT LATER
//    @GetMapping("/{nickname}/posts")
//    public ResponseEntity<?> getUserPosts(@PathVariable("nickname") String nickname) {
//        return ResponseEntity.ok(userService.getUserPosts());
//    }

}
