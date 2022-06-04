package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class SignInController {
    @RequestMapping(value="signIn")
    public String signInForm() {
        return "signIn";
    }

    @PostMapping(value="checkSignIn")
    public String checkSignIN(@ModelAttribute User user, Model model) {
        System.out.println(user.getEmail() +" "+user.getPassword());
        if (!user.getEmail().equals("e")) {
            model.addAttribute("emailValidation", "email is not exist");
        }
        else if (!user.getPassword().equals("p")) {
            model.addAttribute("passwordValidation", "password is wrong");
        }
        model.addAttribute("user", user);
        return "signIn";
    }
}
