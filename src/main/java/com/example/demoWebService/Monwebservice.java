package com.example.demoWebService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Monwebservice {

    @GetMapping("/hello")
    public String Direbjr(){
        return "Bonjour";
    }
}
