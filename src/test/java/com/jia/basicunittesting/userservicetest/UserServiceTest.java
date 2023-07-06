package com.jia.basicunittesting.userservicetest;

import com.jia.basicunittesting.user.User;
import com.jia.basicunittesting.user.UserDto;
import com.jia.basicunittesting.user.UserService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void validateEmail() {
        String email = "jia@gmail.com";

        assertTrue(userService.emailIsValid(email));
    }

    @Test
    void validateEmailWrongFormat() {
        String email = "jiagmail.com";

        assertFalse(userService.emailIsValid(email));
    }

    @Test
    @Order(1)
    void getAllUserTest() {
        List<User> userList = userService.getAllUsers();

        assertNotEquals(userList.size(), 0);
    }

    @Test
    @Order(2)
    void createNewUserTest() {
        UserDto newUser = new UserDto();
        newUser.setName("User 1");
        newUser.setAge("10");

        User userIsSaved = userService.createUser(newUser);

        assertNotNull(userIsSaved.getId());
    }
}
