package org.example.homework.services;

import org.example.homework.models.UserOfApp;
import org.example.homework.repositories.UserRepository;
import org.example.homework.security.UserDtoDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDtoDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDtoDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<UserOfApp> user = userRepository.findByUsername(username);
        if (user.isEmpty()) {
           throw new UsernameNotFoundException("User" + username + " not found");
        }
return new UserDtoDetails(user.get());
    }
}
