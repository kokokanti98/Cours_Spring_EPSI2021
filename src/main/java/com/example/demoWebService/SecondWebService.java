package com.example.demoWebService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecondWebService {

    /**
     * pour le request param : http://localhost:8088/voitures?marque=ferrari
     */
    @GetMapping("/voitures")
    public List<Car> liste(@RequestParam(value = "marque") String brand){
        List<Car> voitures = new ArrayList<Car>();
        voitures.add(new Car("DD55FF", brand, 10));
        voitures.add(new Car("EE66GG", brand, 10000));
        System.out.println("Deuxième WS retourne : " + voitures);
        return voitures;
    }

    @GetMapping("/voitures/{prix}")
    public Car getVoiture(@PathVariable(value = "prix") int price) {
        System.out.println(price);
        return new Car("DD55FF", "Fiat", price);
    }

    /**
     * utiliser post man ou programmer
     * @param car
     */

    @DeleteMapping("/voitures")
    public void delete(@RequestBody Car car) {
        System.out.println(car);
    }

}