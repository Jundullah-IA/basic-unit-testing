package com.jia.basicunittesting.userservicetest;

import com.jia.basicunittesting.BasicUnitTestingApplication;
import com.jia.basicunittesting.user.User;
import com.jia.basicunittesting.user.UserDto;
import com.jia.basicunittesting.user.UserService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = BasicUnitTestingApplication.class)
@TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    MockMvc mockMvc;

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

    @Test
    void listUserTest() throws Exception {
        String url = "/crud/user";

        mockMvc.perform(
                MockMvcRequestBuilders
                        .get(url)
        ).andExpect(status().is2xxSuccessful())
                .andDo(MockMvcResultHandlers.print());
    }

}
