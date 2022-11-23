package com.play.game.demogames.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = User.class)
public class UserTest {

   @Test
    void testUser(){
       User user = new User();
       user.setName("test");
       user.setEmail("test@test.com");
       System.out.println(user.toString());
   }
}
