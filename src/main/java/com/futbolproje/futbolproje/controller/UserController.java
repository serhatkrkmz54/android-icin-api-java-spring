package com.futbolproje.futbolproje.controller;

import com.futbolproje.futbolproje.model.User;
import com.futbolproje.futbolproje.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepos userRepos;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        User user1 = new User(1, "Serhat", "Korkmaz", "korkmaz_serhat@hotmail.com", "123456");
        user1.setId(id);
        return user1;
    }

    @GetMapping("/users")
    public List<User> getUser() {
        List<User> users = new ArrayList<>();
        User user = new User(1,"Serhat", "Korkmaz", "korkmaz_serhat@hotmail.com", "123456");
        users.add(user);
        return users;
    }

    @PostMapping("/kayit-ol")
    public User createUser(@RequestBody User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());

        User savedUser = userRepos.save(newUser);

        return savedUser;
    }

//    @PutMapping("/users/{id}")
//    public User updateUser() {
//
//    }
}
