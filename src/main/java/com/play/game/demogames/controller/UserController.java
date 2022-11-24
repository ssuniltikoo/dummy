package com.play.game.demogames.controller;

import com.play.game.demogames.domain.User;
import com.play.game.demogames.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


@RestController
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUserList")
    public List<User> getListOfUsers() {
        log.info("Get User Lst request received at :{}", LocalDateTime.now());
        return userService.getListOfUsers();
    }

    @GetMapping("/numberOfUsers")
    public int numberOfUsers() {
        log.info("Get No. User t request received at :{}", LocalDateTime.now());
        return userService.getListOfUsers().size();
    }

    /*
        Get mapping with @Pathvariable where param is passed from url only
     */
    @GetMapping("/getUserDetailsFromPathVariable/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable(required = false, name = "id") long id) {
        log.info("user details requested for user with id {} ", id);

        User user = userService.getUserDetails(id).isPresent()
                ? userService.getUserDetails(id).get()
                : null;
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    /*
       Get mapping with @RequestHeader where param is passed as header
    */
    @GetMapping("/getUserUsingRequestHeader")
    public ResponseEntity<User> getUser(@RequestHeader(required = false, name = "id") long id) {
        log.info("user details requested for user with id {} ", id);

        User user = userService.getUserDetails(id).isPresent()
                ? userService.getUserDetails(id).get()
                : null;
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @GetMapping("/getUserUsingRequestParam")
    public ResponseEntity<User> getUserUsingRequestParam(@RequestParam(required = false, name = "id") long id) {
        log.info("user details requested for user with id {} ", id);

        User user = userService.getUserDetails(id).isPresent()
                ? userService.getUserDetails(id).get()
                : null;

        return user!=null? new ResponseEntity<>(user, HttpStatus.OK):new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    //###################################################################################################
    // POST

    @PostMapping("/getUserDetailsFromPathVariablePost/{id}")
    public ResponseEntity<User> getUserDetailsPost(@PathVariable(required = false, name = "id") long id) {
        log.info("user details requested for user with id {} ", id);

        User user = userService.getUserDetails(id).isPresent()
                ? userService.getUserDetails(id).get()
                : null;
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    /*
       Post mapping with @RequestHeader where param is passed as header
    */
    @PostMapping("/getUserUsingRequestHeaderPost")
    public ResponseEntity<User> getUserPost(@RequestHeader(required = false, name = "id") long id) {
        log.info("user details requested for user with id {} ", id);

        User user = userService.getUserDetails(id).isPresent()
                ? userService.getUserDetails(id).get()
                : null;
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    @PostMapping("/getUserUsingRequestParamPost")
    public ResponseEntity<User> getUserUsingRequestParamPost(@RequestParam(required = false, name = "id") long id) {
        log.info("user details requested for user with id {} ", id);

        User user = userService.getUserDetails(id).isPresent()
                ? userService.getUserDetails(id).get()
                : null;
        return new ResponseEntity<>(user, HttpStatus.OK);

    }

    //##################################################################################################

    @GetMapping("/getMultiply")
    @ResponseBody
    public int getMultiply(@RequestParam Map<String, String> numbers) {
        log.info("Request to get multiply received number value is {} . size is {}", numbers, numbers.size());
        String num1 = numbers.get("value1");
        String num2 = numbers.get("value2");
        //numbers.forEach((k,v)-> log.info("key is {} value is {}",k,v));
        int sum = numbers.values().stream().mapToInt(Integer::parseInt).sum();

        log.info("sum of all value are {}", sum);

        return Integer.parseInt(num1) * Integer.parseInt(num2);
    }

    ////////////////////////////////////////////###########################

    @PostMapping("/addUser")
    @ResponseBody
    public ResponseEntity addUser(@RequestBody User user) {
        log.info("User to add is {}", user);
        if (userService.addUser(user)) {
            log.info("User is created");
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else{
            log.info("User is not created");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }


}
