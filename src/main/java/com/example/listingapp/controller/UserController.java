package com.example.listingapp.controller;

import com.example.listingapp.dto.UserCreateDto;
import com.example.listingapp.dto.UserDto;
import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ModelMapper mapper;

    @GetMapping("/users")
    public List<UserDto> findAllUsers(){

        List<User> all = userService.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : all) {
            UserDto userDto = mapper.map(user, UserDto.class);
            userDtos.add(userDto);

        }

        return userDtos;
    }

    @GetMapping("/users/{id}")
    public UserDto findById(@PathVariable("id") int id){
        return mapper.map(userService.findById(id), UserDto.class);
    }

    @PostMapping("/users")
    public UserDto addUser(@RequestBody UserCreateDto user){
        return mapper.map(userService.addUser(mapper.map(user,User.class)), UserDto.class);
    }

    @PutMapping("/users/{id}")
    public UserDto putUser(@PathVariable int id , @RequestBody UserCreateDto user) {
        return mapper.map(userService.putUser(id,mapper.map(user,User.class)), UserDto.class);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }
}
