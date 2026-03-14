package org.example.homework.repositories;

import org.example.homework.dto.FlowerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<FlowerDto, Integer> {

}
