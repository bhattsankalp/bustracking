package com.project.Bus.user.controller;

import com.project.Bus.user.dto.UserVO;
import com.project.Bus.user.entity.User;
import com.project.Bus.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserVO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") String id){
        return userService.getUserById( id );
    }

    @PostMapping("/authenticate")
    public boolean authenticate( @RequestBody User user){
        return userService.authenticate( user );
    }
}
