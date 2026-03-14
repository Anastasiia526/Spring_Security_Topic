package org.example.homework.services.interfaces;

import org.example.homework.dto.FlowerDto;

import java.util.List;
import java.util.Optional;

public interface FlowerServiceInterface {

List<FlowerDto> showAllFlowers();

FlowerDto showFlowerById(int id);

void updateById(Integer id, FlowerDto flowerDto);

void deleteById(Integer id);

void addFlower(FlowerDto flowerDto);
}
