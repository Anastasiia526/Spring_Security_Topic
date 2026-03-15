package org.example.homework.validations;

import jakarta.annotation.PostConstruct;
import org.example.homework.models.UserOfApp;
import org.example.homework.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class AdminInitializer {
private final UserRepository userRepository;
private final BCryptPasswordEncoder bCryptPasswordEncoder;

public AdminInitializer(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
}

@PostConstruct
public void createAdmin(){
    if(userRepository.findByUsername("admin").isEmpty()){
        UserOfApp admin = new UserOfApp();
        admin.setUsername("admin");
        admin.setSurname("Kalitina");
        admin.setRole("ROLE_ADMIN");
        admin.setPassword(bCryptPasswordEncoder.encode("Anastasiia526"));


        userRepository.save(admin);
    }
}


}
