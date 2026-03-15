package org.example.homework.validations;


import org.example.homework.models.UserOfApp;
import org.example.homework.services.UserDtoDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserDtoDetailsService userDtoDetailsService;

    public UserValidator( UserDtoDetailsService userDtoDetailsService) {
        this.userDtoDetailsService = userDtoDetailsService;
    }

    @Override
   public boolean supports(Class<?> clazz) {
        return UserOfApp.class.equals(clazz);
   }

@Override
   public void validate(Object target, Errors errors) {
        UserOfApp user = (UserOfApp) target;

        try{
            userDtoDetailsService.loadUserByUsername(user.getUsername());
        }catch (UsernameNotFoundException ignored){
            return;
        }
        errors.rejectValue("username", "", "Username not found");
   }

}
