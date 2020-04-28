package krenc.mirek.teaipracadomowatydzien71.controller;

import krenc.mirek.teaipracadomowatydzien71.dao.CarDBApi;
import krenc.mirek.teaipracadomowatydzien71.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.text.bidi.BidiRun;

import java.util.List;

@Controller
@RequestMapping("/")
public class CarAPI {

    private CarDBApi carDBApi;

    @Autowired
    public CarAPI(CarDBApi carDBApi) {
        this.carDBApi = carDBApi;
    }

    @GetMapping
    public String showAllCars(Model model)
    {
        model.addAttribute("newCar", new Car());
        model.addAttribute("cars", carDBApi.findAll());
        model.addAttribute("years", new Years());
        return "cars";
    }

    @GetMapping("/{id}")
    public Car showCar(@PathVariable("id") long id)
    {
        return carDBApi.findOne(id);
    }

    @GetMapping("/search/")
    public String showCarsFromProductionYears(@RequestParam("fromYear") int odRoku, @RequestParam("toYear") int doRoku, Model model)
    {
        model.addAttribute("cars", carDBApi.getByProdYear(odRoku, doRoku));
        return "cars_years";
    }

    @GetMapping("/{startYear}/{stopYear}")
    public List<Car> showCarsFromProductionYears(@PathVariable("startYear") int odRoku, @PathVariable("stopYear") int doRoku)
    {
        return carDBApi.getByProdYear(odRoku, doRoku);
    }

    //dodaje samochod bez id
    @PostMapping
    public String add(Car car)
    {
        car.setId(carDBApi.getMaxId());
        car.setColorString(car.getColor().name());
        carDBApi.add(car);

        return "redirect:/";
    }

    @PutMapping
    public Car modify(@RequestBody Car car)
    {
        return carDBApi.update(car);
    }

    @DeleteMapping("/{id}")
    public void remove(@PathVariable long id)
    {
        carDBApi.delete(id);
    }

}
