package org.example.homework.services;

import jakarta.transaction.Transactional;
import org.example.homework.dto.FlowerDto;
import org.example.homework.models.HomeFlower;
import org.example.homework.repositories.FlowerRepository;
import org.example.homework.services.interfaces.FlowerServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowerServiceImpl implements FlowerServiceInterface {

private final FlowerRepository flowerRepository;

public FlowerServiceImpl(FlowerRepository flowerRepository) {
    this.flowerRepository = flowerRepository;
}

    private FlowerDto convertToDto(HomeFlower flower) {
        FlowerDto dto = new FlowerDto();
        dto.setId(flower.getId());
        dto.setName(flower.getName());
        dto.setLatinName(flower.getLatinName());
        dto.setType(flower.getType());
        dto.setRoom(flower.getRoom());
        dto.setHealthStatus(flower.getHealthStatus());
        return dto;
    }

    private HomeFlower convertToEntity(FlowerDto dto) {
        HomeFlower flower = new HomeFlower();
        flower.setName(dto.getName());
        flower.setLatinName(dto.getLatinName());
        flower.setType(dto.getType());
        flower.setRoom(dto.getRoom());
        flower.setHealthStatus(dto.getHealthStatus());
        return flower;
    }


    @Override
    public List<FlowerDto> showAllFlowers() {
        return flowerRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .toList();
    }

    @Override
    public FlowerDto showFlowerById(int id) {
    return flowerRepository.findById(id).stream().map(this::convertToDto)
            .findFirst().orElseThrow(() -> new RuntimeException("Flower with id " + id + " not found"));
    }

    @Transactional
    @Override
    public void updateById(Integer id,  FlowerDto updateFlowerDto) {
    HomeFlower flower = flowerRepository.findById(id).orElseThrow(()-> new RuntimeException("Flower with id " + id + " not found"));

        flower.setHealthStatus(updateFlowerDto.getHealthStatus());
        flower.setLatinName(updateFlowerDto.getLatinName());
        flower.setName(updateFlowerDto.getName());
        flower.setRoom(updateFlowerDto.getRoom());
        flower.setType(updateFlowerDto.getType());
        flowerRepository.save(flower);
    }

    @Override
    public void deleteById(Integer id) {
    flowerRepository.deleteById(id);
}

    @Override
    public void addFlower(FlowerDto flowerDto) {
       HomeFlower flower = convertToEntity(flowerDto);
       flowerRepository.save(flower);
    }

}
