package pl.regula.ksb2modul4thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/elo")
    public String get(Model model){
        Car car = new Car("BMW", "i8");
        model.addAttribute("car", car);
        model.addAttribute("name", "Monia");
        return "elo";
    }
}
