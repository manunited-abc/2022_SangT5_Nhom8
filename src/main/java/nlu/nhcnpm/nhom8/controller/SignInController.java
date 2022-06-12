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

    public String checkSignIN(@ModelAttribute User user, Model model, HttpServletRequest request) {
        boolean isEmailExist = userService.isEmailExist(user.getEmail());
        if (!isEmailExist) {

            model.addAttribute("emailValidation", "email is not exist");
            return "signIn :: email-validation";

        }
        String encryptPassword = encryptPassword(user.getPassword());

        User userSuccessLogin = userService.isPasswordCorrect(user.getEmail(), encryptPassword);
        if (userSuccessLogin == null) {
            model.addAttribute("passwordValidation", "password is wrong");
            return "signIn :: password-validation";
        }

        HttpSession session = request.getSession(true);
        session.setAttribute("user",userSuccessLogin);
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

//    @RequestMapping(value = "signInWithGoogle/{code}")
//    private boolean signInWithGoogle(@PathVariable(value="code") String code) throws IOException {
//        System.out.println(code);
//        if (code != null) {
//            String accessToken = GoogleItem.getToken(code, ConstantSign.GOOGLE_LINK_GET_TOKEN, ConstantSign.GOOGLE_CLIENT_ID, ConstantSign.GOOGLE_CLIENT_SECRET, ConstantSign.GOOGLE_REDIRECT_URI, ConstantSign.GOOGLE_GRANT_TYPE);
//            GooglePojo googlePojo = GoogleItem.getUserInfo(accessToken);
//            request.setAttribute("id", googlePojo.getId());
//            request.setAttribute("name", googlePojo.getName());
//            request.setAttribute("email", googlePojo.getEmail());
//            System.out.println(googlePojo.getId() + " " + googlePojo.getName() + " " + googlePojo.getEmail());
//            if (DaoAuthentication.getInstance().checkPassword(googlePojo.getId()) == false) {
//                request.getSession(true).setAttribute("user", true);
//                request.getRequestDispatcher("/Route?page=listProduct").forward(request, response);
//            }
//            request.getRequestDispatcher("/views/admin/authentication/signIn/signIn.jsp").forward(request, response);
//            return false;
//        }
//        return false;
//    }
}
