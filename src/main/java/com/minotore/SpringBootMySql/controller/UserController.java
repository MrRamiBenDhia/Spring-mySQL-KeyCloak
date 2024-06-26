package com.minotore.SpringBootMySql.controller;


import com.minotore.SpringBootMySql.Service.UserService;

import com.minotore.SpringBootMySql.model.User;
import com.minotore.SpringBootMySql.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//@Tag(name = "User Management ;-)")

@RequestMapping("/user")
@Controller
public class UserController {
    @Autowired
    UserRepo userRepo;
    @Autowired
    UserService userService;

    @GetMapping()
    public List<User> getAllUser() {
        return userRepo.findAll();
    }

    @PostMapping()
    public User createUser(@RequestBody User user) {
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userService.findByUID(id).orElse(new User());
    }

    @PatchMapping("/{id}")

    public User updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        if (user.getUID() == null) {
            user.setUID(id);
        }
        user.setUpdatedAt(new Date());
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);

    }
}
