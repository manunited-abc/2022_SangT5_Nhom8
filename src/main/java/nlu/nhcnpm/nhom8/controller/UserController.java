package nlu.nhcnpm.nhom8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserController {
    @GetMapping(value = {"/","index.html"})
    public String hello(HttpServletRequest request, Model model){
        String s = "Nguyễn Khải Hiếu";
        request.setAttribute("name",s);
        model.addAttribute("mssv","19130071");
        return "index";
    }
}
