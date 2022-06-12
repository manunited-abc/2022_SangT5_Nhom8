package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.ConstantSign;
import nlu.nhcnpm.nhom8.model.dto.GoogleItem;
import nlu.nhcnpm.nhom8.model.dto.GooglePojo;
import nlu.nhcnpm.nhom8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Controller
public class SignUpController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "signUp")
    public String signUpForm() {
        return "signUp";
    }
    @PostMapping(value = "checkSignUp")
    public String checkSignUp(@ModelAttribute User user, Model model) {
        boolean isEmailExist = userService.isEmailExist(user.getEmail());
        if (isEmailExist) {
            model.addAttribute("emailValidation", "email is not exist");
            return "signIn :: email-validation";
        }
//        String encryptPassword = encryptPassword(user.getPassword());
        userService.insertUser(user.getEmail(), user.getPassword());
        System.out.println(123);
        return "index";
    }


}

