package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignUpController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "signUp")
    public String signUpForm() {
        return "signUp";
    }
    @PostMapping(value = "checkSignUp")
    public String checkSignUp(@ModelAttribute User user, Model model, @RequestParam String confirmPassword) {
        boolean isEmailExist = userService.isEmailExist(user.getEmail());
        if (isEmailExist) {
            model.addAttribute("emailValidation", "email is exist");
            return "signUp :: email-validation";
        }
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("confirmPasswordValidation", "confirm password is not correct");
            return "signUp :: confirmPassword-validation";
        }
        String encryptPassword = userService.encryptPassword(user.getPassword());
        userService.insertUser(user.getEmail(), encryptPassword, "customer");
        return "index";
    }


}

