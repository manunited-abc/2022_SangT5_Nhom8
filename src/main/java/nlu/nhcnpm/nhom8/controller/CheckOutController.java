package nlu.nhcnpm.nhom8.controller;

import nlu.nhcnpm.nhom8.entity.*;
import nlu.nhcnpm.nhom8.model.dto.*;
import nlu.nhcnpm.nhom8.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class CheckOutController {
    @Autowired
    MovieService movieService;
    @Autowired
    TheatreService theatreService;
    @Autowired
    SeatService seatService;
    @Autowired
    ComboFoodService comboFoodService;
    @Autowired
    OrderService orderService;
    double ticketPrice =0;
    double comboPrice = 0;
    double totalBill = 0;
    @GetMapping("checkout/{idMovie}/{idTheatre}/{time}/{date}/{idSeat}/{idCombo}")
    //15. Chuyển đến trang CheckOutGUI
    public String checkout(Model model, @PathVariable String idMovie,
                        @PathVariable String idTheatre, @PathVariable String time,
                        @PathVariable String date, @PathVariable String idSeat, @PathVariable String idCombo,
                        HttpServletRequest request) throws ParseException {
        MovieDto movieDto = movieService.getMovieById(id(idMovie));
        model.addAttribute("movie", movieDto);

        TheatreDto theatreDto = theatreService.getTheatreById(id(idTheatre));
        model.addAttribute("theatre",theatreDto);

        // Lấy id ghế và tính tổng giá ghế
        String [] split = idSeat.split(",");
        System.out.println(Arrays.toString(split));
        List<SeatDetail> seatDetails = new ArrayList<>();
        StringBuilder codeSeats = new StringBuilder();
        for(String s: split){
            Seat seat = seatService.getSeatById(id(s));
            SeatDetail seatDetail= new SeatDetail();
            seatDetail.setSeat(seat);
            seatDetails.add(seatDetail);
            ticketPrice +=seat.getPrice();
            codeSeats.append(seat.getCodeSeat()+", ");
        }
        model.addAttribute("ticketPrice",ticketPrice);
        model.addAttribute("codeSeats",codeSeats.toString().substring(0,codeSeats.length()-2));

        model.addAttribute("time",time);
        model.addAttribute("date",date);

        //Liệt kê danh sách combofood
        List<ComboFoodDetail> comboFoodDetails = listedComboFood(idCombo);
        model.addAttribute("combos", comboFoodDetails);
        model.addAttribute("comboPrice", comboPrice);

        //Tính tổng hóa đơn
        totalBill = ticketPrice+ comboPrice;
        model.addAttribute("totalBill", totalBill);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);

        //Lưu order vào session
        saveOrderLocal(idMovie,idTheatre,date,time, user, comboFoodDetails, seatDetails,session);

        //Kiểm tra user đã đăng nhập chưa
        if(user!=null) {
            return "check-out";
        }else{
            return "redirect:/signIn";
        }
    }
    //Chuyển đổi kiểu string thành int
    public int id(String id){
        return Integer.parseInt(id);
    }
    public List<ComboFoodDetail> listedComboFood(String idCombo){
        String [] idComboArr = idCombo.split(",");
        Map<Integer,Integer> map = new HashMap<>();
        if(idComboArr.length>1) {
            for (int i = 1; i < idComboArr.length; i++) {
                if(!map.containsKey(id(idComboArr[i]))){
                    map.put(id(idComboArr[i]),1);
                }else{
                    map.put(id(idComboArr[i]) ,map.get(id(idComboArr[i]))+1);
                }

            }
        }
        List<ComboFoodDetail> comboFoodDetails = new ArrayList<>();
        // Thống kê combo và số lượng
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ComboFood comboFood = comboFoodService.getComboFoodById(entry.getKey());
            ComboFoodDetail comboFoodDetail = new ComboFoodDetail();
            comboFoodDetail.setComboFood(comboFood);
            comboFoodDetail.setQuantity(entry.getValue());
            comboFoodDetails.add(comboFoodDetail);
            comboPrice+=comboFood.getPrice()*entry.getValue();
        }
        return comboFoodDetails;
    }
    public Calendar convertDate(String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String dateInString = date+ " 00:00:00";
        Date d = sdf.parse(dateInString);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(d);
        return calendar;
    }
    public void saveOrderLocal(String idMovie, String idTheatre, String date, String time, User user,
                               List<ComboFoodDetail> comboFoodDetails,
                               List<SeatDetail> seatDetails ,HttpSession session) throws ParseException {
        Order order = new Order();
        Movie movie = movieService.getMovieById2(id(idMovie));
        Theatre theatre = theatreService.getTheatreById2(id(idTheatre));
        Calendar showingDate = convertDate(date);
        order.setCreateDate(Calendar.getInstance());
        order.setComboFoodDetails(comboFoodDetails);
        order.setUser(user);
        order.setShowingDate(showingDate);
        order.setShowingTime(time);
        order.setMovie(movie);
        order.setTheatre(theatre);
        for(ComboFoodDetail comboFoodDetail : comboFoodDetails){
            comboFoodDetail.setOrder(order);
        }
        for(SeatDetail seatDetail : seatDetails){
            seatDetail.setOrder(order);
        }
        session.setAttribute("order", order);
        session.setAttribute("comboFoodDetails", comboFoodDetails);
        session.setAttribute("seatDetails", seatDetails);
    }

}
