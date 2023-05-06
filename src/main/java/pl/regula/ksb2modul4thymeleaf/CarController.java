package pl.regula.ksb2modul4thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private List<Car> cars;

    public CarController() {
        Car car = new Car(1L, "BMW", "i8");
        Car car1 = new Car(2L, "Fiat", "Uno");
        Car car2 = new Car(3L, "Opel", "Astra");
        Car car3 = new Car(4L, "Seat", "Ibiza");
        cars = new ArrayList<>();
        cars.add(car);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    @GetMapping("/index")
    public String getCar(Model model) {
        model.addAttribute("cars", cars);
        model.addAttribute("newCar", new Car());
        return "index";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car car) {
        cars.add(car);
        System.out.println(car);
        return "redirect:/index";
    }

    @GetMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id) {
        Car car = cars.stream().filter(c -> c.getId() == id).
                findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid id!"));
        cars.remove(car);
        return "redirect:/index";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Car currentCar = cars.stream().filter(c -> c.getId() == id).
                findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid id!"));
        cars.remove(currentCar);
        model.addAttribute("car", currentCar);
        return "update-car";
    }

    @PostMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Car car, Model model, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            car.setId(id);
            return "update-car";
        }
        cars.add(car);
        return "redirect:/index";
    }
}
