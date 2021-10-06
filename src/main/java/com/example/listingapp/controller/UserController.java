package com.example.listingapp.controller;

import com.example.listingapp.dto.UserAuthDto;
import com.example.listingapp.dto.UserAuthResponseDto;
import com.example.listingapp.dto.UserCreateDto;
import com.example.listingapp.dto.UserDto;
import com.example.listingapp.model.User;
import com.example.listingapp.service.UserService;
import com.example.listingapp.util.JwtTokenUtil;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper mapper;
    private final JwtTokenUtil jwtTokenUtil;

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
        user.setPassword(passwordEncoder.encode(user.getPassword()));
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

    @PostMapping("/users/auth")
    public ResponseEntity<?> auth(@RequestBody UserAuthDto userAuthDto) {
        Optional<User> byEmail = userService.findByEmail(userAuthDto.getEmail());

        if (byEmail.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .build();
        }

        User user = byEmail.get();
        if (passwordEncoder.matches(userAuthDto.getPassword(), user.getPassword())) {
            return ResponseEntity.ok(UserAuthResponseDto.builder()
                    .token(jwtTokenUtil.generateToken(user.getEmail()))
                    .userDto(mapper.map(user, UserDto.class))
                    .build());
        }
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .build();
    }


}
