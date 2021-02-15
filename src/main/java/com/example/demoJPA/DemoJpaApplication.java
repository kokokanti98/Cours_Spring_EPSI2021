package com.example.demoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoJpaApplication.class, args);
	}

	public void Regarder_tous(){
		Car car1 = new Car("1123AA","ferrari",1000);
		Car car2 = new Car("1123AB","ferrari",2000);

	}

}
