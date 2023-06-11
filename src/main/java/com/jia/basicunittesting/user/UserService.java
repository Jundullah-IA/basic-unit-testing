package com.jia.basicunittesting.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    List<User> getAllUsers() {
        return userRepository.findAll();
    }

    User getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setAge(userDto.getAge());
        return userRepository.save(user);
    }

    User updateUser(UUID userId, UserDto userDto) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (userDto.getName() != null) {user.setName(userDto.getName());}
        if (userDto.getAge() != null) {user.setAge(userDto.getAge());}

        return userRepository.save(user);
    }

    void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }
}
