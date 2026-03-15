package org.example.homework.repositories;

import org.example.homework.models.HomeFlower;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlowerRepository extends JpaRepository<HomeFlower, Integer> {

}
