package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.GoogleItem;
import nlu.nhcnpm.nhom8.model.dto.GooglePojo;
import nlu.nhcnpm.nhom8.service.UserService;
import nlu.nhcnpm.nhom8.service.api_goggle.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SignUpController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "signUp")
    public String signUpForm() {
        return "signUp";
    }
    @RequestMapping(value = "signWithGoogle")
    public String signWithGoggle(@RequestParam String code, HttpServletRequest request) throws IOException {
            String accessToken = GoogleItem.getToken(code, Constant.GOOGLE_LINK_GET_TOKEN, Constant.GOOGLE_CLIENT_ID, Constant.GOOGLE_CLIENT_SECRET, Constant.GOOGLE_REDIRECT_URI, Constant.GOOGLE_GRANT_TYPE);
            GooglePojo googlePojo = GoogleItem.getUserInfo(accessToken);
        boolean isEmailExist = userService.isEmailExist(googlePojo.getEmail());
        if (isEmailExist) {
            String encryptPassword = userService.encryptPassword(googlePojo.getId());
            User userSuccessLogin = userService.isPasswordCorrect(googlePojo.getEmail(), encryptPassword);
            HttpSession session = request.getSession(true);
            session.setAttribute("user",userSuccessLogin);
            return "index";
        }
        else {
            String encryptPassword = userService.encryptPassword(googlePojo.getId());
            userService.insertUser(googlePojo.getEmail(), encryptPassword, "customer");
            return "index";
        }
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

