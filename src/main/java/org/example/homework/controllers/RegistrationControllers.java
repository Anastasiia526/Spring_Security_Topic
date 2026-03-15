package org.example.homework.controllers;

import jakarta.validation.Valid;
import org.example.homework.models.UserOfApp;
import org.example.homework.services.RegistrationService;
import org.example.homework.validations.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class RegistrationControllers {

    private final RegistrationService registrationService;
    private final UserValidator userValidator;

    @Autowired
    public RegistrationControllers(RegistrationService registrationService,
                                   UserValidator userValidator) {
        this.registrationService = registrationService;
        this.userValidator = userValidator;
    }

    @GetMapping("/login")
    public String loginPage() {
        return "auth/login";
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") UserOfApp user) {
        return "auth/registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") @Valid UserOfApp user,
                                      BindingResult bindingResult) {

        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors())
            return "auth/registration";

        registrationService.register(user);

        return "redirect:/auth/login";
    }
}
