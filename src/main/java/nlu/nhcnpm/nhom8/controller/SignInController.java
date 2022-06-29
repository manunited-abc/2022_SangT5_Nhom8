package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;

//import nlu.nhcnpm.nhom8.model.dto.ConstantSign;
//import nlu.nhcnpm.nhom8.model.dto.GoogleItem;
//import nlu.nhcnpm.nhom8.model.dto.GooglePojo;
import nlu.nhcnpm.nhom8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



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

    public String checkSignIn(@ModelAttribute User user, Model model, HttpServletRequest request) {
        boolean isEmailExist = userService.isEmailExist(user.getEmail());
        if (!isEmailExist) {
            model.addAttribute("emailValidation", "email is not exist");
            return "signIn :: email-validation";

        }
        String encryptPassword = userService.encryptPassword(user.getPassword());
        User userSuccessLogin = userService.isPasswordCorrect(user.getEmail(), encryptPassword);
        if (userSuccessLogin == null) {
            model.addAttribute("passwordValidation", "password is wrong");
            return "signIn :: password-validation";
        }
        saveUserToSession(request, user);
        return "index";
    }

    private void saveUserToSession(HttpServletRequest request, User user) {
        HttpSession session = request.getSession(true);
        session.setAttribute("user",user);
    }
}
