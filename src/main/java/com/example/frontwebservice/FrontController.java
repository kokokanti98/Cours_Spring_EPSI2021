package com.example.frontwebservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class FrontController {
    @Autowired
    DiscoveryClient discoveryClient;
    @GetMapping("/hi")
    public String hello() {
        //instancier les microservice schema tp c est la fleche 2
        List<ServiceInstance> instances = discoveryClient.getInstances("NAME-OF-THE-MICROSERVICE1");

        ServiceInstance test = instances.get(0);
        //prendre son hostname ici c est localhost
        String hostname = test.getHost();
        //prendre son port ici c est 8760
        int port = test.getPort();
        //creation d une nouvelle classe ResTemplate
        RestTemplate restTemplate = new RestTemplate();
        //creation de l'url dont on veut accéder
        String microservice1Address = "http://" + hostname + ":" + port +"/hello";
        System.out.println(microservice1Address);
        //utilisation de la classe ResTemplate afin de récuperer la valeur retourner par le webservice ici c'est un string
        ResponseEntity<String> response =
                restTemplate.getForEntity(microservice1Address, String.class);
        //prendre cette valeur retour string
        String s = response.getBody();
        //re retourner cette meme valeur donc au final ca affiche "bonjour"
        return s;
    }
}
