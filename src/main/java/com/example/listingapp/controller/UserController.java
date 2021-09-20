package com.example.listingapp.controller;

import com.example.listingapp.model.Category;
import com.example.listingapp.model.User;
import com.example.listingapp.service.CategoryService;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> findAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") int id){
        return userService.findById(id);
    }
    @PostMapping("/users")
    public User addCategory(@RequestBody User user){
        return userService.addUser(user);
    }
    @PutMapping("/users/{id}")
    public User putCategory(@PathVariable int id , @RequestBody User user) {
        return userService.putUser(id, user);
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
