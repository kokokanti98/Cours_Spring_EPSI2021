package com.example.demoWebService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;

@SpringBootApplication
public class DemoWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoWebServiceApplication.class, args);
	}
	ArrayList<Car> cars = new ArrayList<Car>();

	public void MonWebService() {
		Car car = new Car();
		car.setPlateNumber("11AA22");
		cars.add(car);
		car = new Car();
		car.setPlateNumber("22BB33");
		cars.add(car);
	}

	@GetMapping("/cars")
	ArrayList<Car> getListOfCars(){
		return cars;
	}

	@GetMapping("/cars/{plaque}")
	Car getCar(@PathVariable(value = "plaque") String immatriculation) {
		System.out.println(immatriculation);
		// parcourir avec une boucle le tableau des voitures à la recherche de la voiture qui a la plaque immatriculation
		return null;
	}

}
