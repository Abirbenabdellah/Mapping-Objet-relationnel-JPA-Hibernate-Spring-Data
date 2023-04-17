package com.example.jpa_mtm.web;

import com.example.jpa_mtm.entities.User;
import com.example.jpa_mtm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/users/{username")
    public User user(@PathVariable String username){
        User user=userService.findUserByName(username);
        return  user;

    }
}
