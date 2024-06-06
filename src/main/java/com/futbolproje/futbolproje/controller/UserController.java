package com.futbolproje.futbolproje.controller;

import com.futbolproje.futbolproje.model.User;
import com.futbolproje.futbolproje.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepos userRepos;

    @Autowired
    public UserController(UserRepos userRepos) {
        this.userRepos = userRepos;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
        Optional<User> user = userRepos.findById(id);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        String errorMessage = "Bu id ile kullanıcı bulunamadı: " + id;
        return new ResponseEntity<>(errorMessage,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users")
    public List<User> getUser() {
        return userRepos.findAll();
    }

    @PostMapping("/kayit-ol")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        User newUser = new User();
        newUser.setId(user.getId());
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        User savedUser = userRepos.save(newUser);
        return new ResponseEntity<>("Kullanıcı başarıyla oluşturuldu. Kullanıcı id: "+savedUser.getId(), HttpStatus.CREATED);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User newUser = userRepos.findById(id).orElse(null);
        if(newUser == null) {
            return new ResponseEntity<>("Bu id ile kullanıcı bulunamadı: "+id, HttpStatus.NOT_FOUND);
        }
        else{
            newUser.setId(user.getId());
            newUser.setFirstName(user.getFirstName());
            newUser.setLastName(user.getLastName());
            newUser.setEmail(user.getEmail());
            newUser.setPassword(user.getPassword());
            userRepos.save(newUser);
        }
        return new ResponseEntity<>("Kullanıcı başarıyla güncellendi. Güncellenen kullanıcı id: "+id, HttpStatus.OK);
    }


    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Integer id){
        userRepos.deleteById(id);
        return "Kullanıcı başarıyla silindi. Silinen kullanıcı id: "+id;
    }
}
