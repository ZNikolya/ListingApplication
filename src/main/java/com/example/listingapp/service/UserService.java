package com.example.listingapp.service;

import com.example.listingapp.dto.UserDto;
import com.example.listingapp.model.Category;
import com.example.listingapp.model.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(int id);
    User addUser(User user);
    User putUser(int id, User user);
    void deleteUser(int id);
}
