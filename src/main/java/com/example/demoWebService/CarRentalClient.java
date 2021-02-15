package com.example.demoWebService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class CarRentalClient {

    private static final Logger log = LoggerFactory.getLogger(CarRentalClient.class);

    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<Car> request = new HttpEntity<>(new Car("44QQ66", "Peugeot", 12));
        restTemplate.postForObject("http://localhost:8088/cars", request, Car.class);

        List cars = restTemplate.getForObject("http://localhost:8088/cars", List.class);
        log.info(cars.toString());

    }

}