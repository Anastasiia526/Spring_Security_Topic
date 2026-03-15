package org.example.homework.controllers;

import jakarta.validation.Valid;
import org.example.homework.dto.FlowerDto;
import org.example.homework.services.FlowerServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/flowers")
public class FlowerControllers {
    private final FlowerServiceImpl flowerDtoService;

    public FlowerControllers(FlowerServiceImpl flowerDtoService) {
        this.flowerDtoService = flowerDtoService;
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public String showAllFlowers(Model model) {
        model.addAttribute("flowers", flowerDtoService.showAllFlowers());
        return "homeFlowers";
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
   @GetMapping("/{id}")
    public String showFlower(@PathVariable("id") int id, Model model) {
        model.addAttribute("flower", flowerDtoService.showFlowerById(id));
        return "show";
   }

   @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/new")
    public String createNewFlower(@ModelAttribute ("flower") FlowerDto flower) {
        return "createFlower";
    }

    @PostMapping
    public String create(@ModelAttribute("flower") @Valid FlowerDto flower, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        flowerDtoService.addFlower(flower);
        return "redirect:/flowers";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{id}/update")
    public String editFlower(Model model, @PathVariable("id") Integer id){
        model.addAttribute("flower", flowerDtoService.showFlowerById(id));
        return "updateFlower";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/{id}")
    public String updateFlower(@ModelAttribute("flower") FlowerDto flower, @PathVariable("id") Integer id) {

        flowerDtoService.updateById(id, flower);
        return "redirect:/flowers";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/delete/{id}")
    public String deleteFlower(@PathVariable("id") Integer id) {
        flowerDtoService.deleteById(id);
        return "redirect:/flowers";
    }
}
