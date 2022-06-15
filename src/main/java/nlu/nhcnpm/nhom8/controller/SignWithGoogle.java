package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.model.dto.google_api.GooglePojo;
import nlu.nhcnpm.nhom8.service.UserService;
import nlu.nhcnpm.nhom8.service.google_api.Constant;
import nlu.nhcnpm.nhom8.service.google_api.GoogleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class SignWithGoogle {
    @Autowired
    UserService userService;
    @RequestMapping(value = "signWithGoogle")
    public String signWithGoggle(@RequestParam String code, HttpServletRequest request) throws IOException {
        System.out.println(123);
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
}
