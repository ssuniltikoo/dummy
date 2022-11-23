package com.play.game.demogames.repo;

import com.play.game.demogames.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest(classes = {UserRepository.class,User.class})
@DataJpaTest
public class UserRepositoryIntegrationTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void test_UserSaved(){

        userRepository.save(new User("test","test@test.com"));
        List<User> listUsers = userRepository.findAll();
        System.out.println(listUsers.size());
    }
}
