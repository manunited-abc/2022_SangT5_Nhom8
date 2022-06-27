package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class InfoUserController {

    @GetMapping("infoUser")
    public String infoUserForm(HttpServletRequest request, Model model){
//        System.out.println("Name : "+name);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
//        model.addAttribute("userDto",user);
        model.addAttribute("user",user);


        if (user != null) {
            return "updateUser";
        } else {
            return "redirect:/signIn";
        }
    }
}
