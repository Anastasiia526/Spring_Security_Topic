package org.example.homework.repositories;

import org.example.homework.models.UserOfApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserOfApp,Long> {

    Optional<UserOfApp> findByUsername(String username);

}
