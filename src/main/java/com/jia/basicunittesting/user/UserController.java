package com.jia.basicunittesting.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/crud/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping()
    public ResponseEntity<Object> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<Object> getUserbyId(@PathVariable("userId") UUID userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @PostMapping()
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.createUser(userDto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable("userId") UUID userId, @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.updateUser(userId, userDto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Object> deleteUser(@PathVariable("userId") UUID userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
