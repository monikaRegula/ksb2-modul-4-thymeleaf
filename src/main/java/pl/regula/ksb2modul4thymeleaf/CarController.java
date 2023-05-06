package pl.regula.ksb2modul4thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    @GetMapping("/car")
    public String get(Model model) {
        Car car = new Car("BMW", "i8");
        Car car1 = new Car("Fiat", "Uno");
        Car car2 = new Car("Opel", "Astra");
        Car car3 = new Car("Seat", "Ibiza");
        List<Car> cars = Arrays.asList(car, car2, car3, car1);

        model.addAttribute("cars",cars);
        model.addAttribute("car", car);
        model.addAttribute("name", "Monia");

        return "car";
    }
}
