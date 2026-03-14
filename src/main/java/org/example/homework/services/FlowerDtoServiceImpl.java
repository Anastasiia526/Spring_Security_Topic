package org.example.homework.services;

import jakarta.transaction.Transactional;
import org.example.homework.dto.FlowerDto;
import org.example.homework.repositories.FlowerRepository;
import org.example.homework.services.interfaces.FlowerServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerDtoServiceImpl implements FlowerServiceInterface {

private final FlowerRepository flowerRepository;

public FlowerDtoServiceImpl(FlowerRepository flowerRepository) {
    this.flowerRepository = flowerRepository;
}


    @Override
    public List<FlowerDto> showAllFlowers() {
        return flowerRepository.findAll();
    }

    @Override
    public FlowerDto showFlowerById(int id) {
    return flowerRepository.findById(id).orElseThrow(()->new RuntimeException("Flower not found"));
    }

    @Transactional
    @Override
    public void updateById(Integer id,  FlowerDto updateFlowerDto) {
    FlowerDto flowerDto = flowerRepository.findById(id).orElse(null);
    if (flowerDto != null) {
        flowerDto.setHealthStatus(updateFlowerDto.getHealthStatus());
        flowerDto.setLatinName(updateFlowerDto.getLatinName());
        flowerDto.setName(updateFlowerDto.getName());
        flowerDto.setRoom(updateFlowerDto.getRoom());
        flowerDto.setType(updateFlowerDto.getType());
        flowerRepository.save(flowerDto);
    }
    }

    @Override
    public void deleteById(Integer id) {
    FlowerDto flowerDto = flowerRepository.findById(id).orElseThrow(()-> new RuntimeException("Flower not found"));
    flowerRepository.delete(flowerDto);
}

    @Override
    public void addFlower(FlowerDto flowerDto) {
        flowerRepository.save(flowerDto);
    }

}
