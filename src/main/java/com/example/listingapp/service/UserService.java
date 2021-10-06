package com.example.listingapp.service;

import com.example.listingapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();
    User findById(int id);
    User addUser(User user);
    User putUser(int id, User user);
    void deleteUser(int id);
    Optional<User> findByEmail(String email);

}
