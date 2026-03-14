package org.example.homework.repositories;

import org.example.homework.dto.UserDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDto,Long> {

    Optional<UserDto> findByUsername(String username);

}
