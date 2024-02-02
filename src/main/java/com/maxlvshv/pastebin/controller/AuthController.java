package com.maxlvshv.pastebin.controller;

import com.maxlvshv.pastebin.entity.UserEntity;
import com.maxlvshv.pastebin.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserEntity user) {
        try {
            userService.addUser(user);
            return ResponseEntity.ok("You welcome!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Nickname already exist");
        }
    }
}
