package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.ComboFoodDetail;
import nlu.nhcnpm.nhom8.entity.Order;
import nlu.nhcnpm.nhom8.entity.SeatDetail;
import nlu.nhcnpm.nhom8.entity.User;
import nlu.nhcnpm.nhom8.service.ComboFoodService;
import nlu.nhcnpm.nhom8.service.OrderService;
import nlu.nhcnpm.nhom8.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    SeatService seatService;
    @Autowired
    ComboFoodService comboFoodService;
    @Autowired
    OrderService orderService;
    @GetMapping("order-success")
    public String order(Model model, HttpServletRequest request){

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        //Lưu đơn hàng vào csdl
        Order order = (Order) session.getAttribute("order");
        List<ComboFoodDetail> comboFoodDetails = (List<ComboFoodDetail>) session.getAttribute("comboFoodDetails");
        List<SeatDetail> seatDetails = (List<SeatDetail>) session.getAttribute("seatDetails");
        orderService.createOrder(order);
        for(ComboFoodDetail comboFoodDetail : comboFoodDetails){
            comboFoodDetail.setOrder(order);
            comboFoodService.createComboFoodDetail(comboFoodDetail);
        }
        for(SeatDetail seatDetail : seatDetails){
            seatDetail.setOrder(order);
            seatService.createSeatDetail(seatDetail);
        }

        //Kiểm tra user đã đăng nhập chưa
        if(user!=null) {
            return "order-success";
        }else{
            return "redirect:/signIn";
        }
    }
}
