package com.jia.basicunittesting;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BasicUnitTestingApplicationTests {

    @Test
    void contextLoads() {
        int num = 3 + 2;

        System.out.println(num);

        assertEquals(num, 5);
    }

    @Test
    void newUnitTest() {
        System.out.println("test add");
        int add = 5 + 2;

        System.out.println(add);

        assertEquals(7, add, "add equal to 2");
    }



}
