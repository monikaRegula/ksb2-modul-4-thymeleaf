package pl.regula.ksb2modul4thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars;

    public CarController() {
        Car car = new Car("BMW", "i8");
        Car car1 = new Car("Fiat", "Uno");
        Car car2 = new Car("Opel", "Astra");
        Car car3 = new Car("Seat", "Ibiza");
        cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @GetMapping("/car")
    public String getCar(Model model) {
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "car";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        cars.add(car);
        System.out.println(car);
        return "redirect:/car";
    }
}
