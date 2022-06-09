package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

@Controller
public class SignInController {
    @RequestMapping(value = "signIn")
    public String signInForm() {
        return "signIn";
    }

    @PostMapping(value = "checkSignIn")
    public String checkSignIN(@ModelAttribute User user, Model model) {
        if (!user.getEmail().equals("e")) {
            model.addAttribute("emailValidation", "email is not exist");
            return "signIn :: email-validation";
        } else if (!user.getPassword().equals("p")) {
            model.addAttribute("passwordValidation", "password is wrong");
            return "signIn :: password-validation";
        }
        model.addAttribute("user", user);
        return "signIn";
    }
}
