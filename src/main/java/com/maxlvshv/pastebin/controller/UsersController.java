package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> showAll() {
        return ResponseEntity.ok(userService.showUsers());
    }

    @GetMapping("/{nickname}")
    public ResponseEntity<?> showUser(@PathVariable("nickname") String nickname) {
        return ResponseEntity.ok(userService.showOneUser(nickname));
    }

//    @GetMapping("/{nickname}/posts")
//    private ResponseEntity<?> showUserPost(@PathVariable("nickname") String nickname) {
//        return ResponseEntity.ok(userService.getUserPost(nickname));
//    }

}
