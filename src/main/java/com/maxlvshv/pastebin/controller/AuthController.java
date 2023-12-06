package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.entity.UserEntity;
import com.maxlvshv.pastebin.model.UserPassword;
import com.maxlvshv.pastebin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signin")
    private ResponseEntity<?> signin(@RequestBody UserPassword user) {
        try {
            if (userService.authorizedName(user.getNickname()) && userService.authorizedPassword(user.getPassword()))
                return ResponseEntity.ok(user.getNickname());
        } catch (Exception e) {
            throw new RuntimeException();
        }
        return ResponseEntity.badRequest().body("User not found");
    }

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("You welcome!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("nickname already exist");
        }
    }
}
