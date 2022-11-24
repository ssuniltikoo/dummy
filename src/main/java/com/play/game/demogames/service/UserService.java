package com.play.game.demogames.service;

import com.play.game.demogames.domain.User;
import com.play.game.demogames.repo.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("UserService")
public class UserService {
  //  @Qualifier("UserRepo")
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public List<User> getListOfUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserDetails(Long id){
        if(id==null){
            id= Long.valueOf(1);
        }
        return userRepository.findById(id);
    }
}
