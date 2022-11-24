package com.play.game.demogames.service;

import com.play.game.demogames.domain.User;
import com.play.game.demogames.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service("UserService")
@Slf4j
public class UserService {
  //  @Qualifier("UserRepo")
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getListOfUsers(){
        return userRepository.findAll();
    }

    public boolean addUser(User user){
        if(user != null && StringUtils.hasLength(user.getName()) ){
            userRepository.save(user);
            return true;
        }return false;
    }

    public Optional<User> getUserDetails(Long id){
        if(id==null){
            id= Long.valueOf(1);
        }
        Optional<User> user = userRepository.findById(id);
        log.info("@@@ user returned from db is {}", user);
        return user;
    }
}
