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
public class UpdateUserController {
    @Autowired
    UserService userService;

    @GetMapping("updateUser")
    public String updateUserForm(HttpServletRequest request, Model model, @RequestParam String name ,@RequestParam String phone){
        System.out.println("Name : "+name);
        System.out.println("Phone : "+phone);
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        user.setName(name);
        user.setPhoneNumber(phone);


        model.addAttribute("user",user);
//        model.addAttribute("user",user);
        model.addAttribute("testValue",true);

        userService.updateUser(user);

        return "updateUser";
    }
}
