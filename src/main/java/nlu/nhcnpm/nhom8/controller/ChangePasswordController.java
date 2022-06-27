package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class ChangePasswordController {
    @Autowired
    UserService userService;

    @GetMapping("changePassword")
    public String updateUserForm(HttpServletRequest request, Model model, @RequestParam String newPassword) {

        try {
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            user.setPassword(userService.encryptPassword(newPassword));


            model.addAttribute("user", user);
            model.addAttribute("testValueChangePass",true);


            userService.changePassword(user);


        } catch (RuntimeException e) {
            e.printStackTrace();
        }

        return "changePassword";
    }
}
