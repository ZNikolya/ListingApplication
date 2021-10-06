package com.example.listingapp.security;

import com.example.listingapp.model.User;
import com.example.listingapp.repository.UserRepository;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class CurrentUserDetailServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userService.findByEmail(s);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new CurrentUser(user.get());
    }
}