package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.MovieDto;
import nlu.nhcnpm.nhom8.service.MovieService;
import nlu.nhcnpm.nhom8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;


//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

@Controller
public class SignInController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "signIn")
    public String signInForm() {
        return "signIn";
    }

    @PostMapping(value = "checkSignIn")
    public String checkSignIN(@ModelAttribute User user, Model model) {
        boolean isEmailExist = userService.isEmailExist(user.getEmail());
        if (!isEmailExist) {
            model.addAttribute("emailValidation", "email is not exist");
            return "signIn :: email-validation";
        }
        String encryptPassword = encryptPassword(user.getPassword());
        boolean isPasswordCorrect = userService.isPasswordCorrect(user.getEmail(), encryptPassword);
        if (!isPasswordCorrect) {
            model.addAttribute("passwordValidation", "password is wrong");
            return "signIn :: password-validation";
        }
        return "index";
    }


    private String encryptPassword(String password) {
        String encryptPassword = password;
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(password.getBytes());
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encryptPassword = s.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encryptPassword;
    }
}
