package com.example.demoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
public class EssaiController {
    @Autowired
    private CarRepository carrepo;

    //Regarder tous les voitures au lancement de l'application la bdd est vide alors tout d'abord créer une bdd à l aide
    //de http://localhost:8088/voitures/1122AA/feri/24000 par exemple avant de lancer http://localhost:8088/voitures
    @GetMapping("/voitures")
    public List<Car> findAll() {

        var it = carrepo.findAll();

        var cars = new ArrayList<Car>();
        it.forEach(e -> cars.add(e));

        return cars;
    }
    @GetMapping("/voitures/{plateNumber}")
    public String Car_deleteById(@PathVariable(value = "plateNumber") String p_plateNumber) {
        String success;
        if(carrepo != null){
            carrepo.deleteById(p_plateNumber);
            success = "Voiture supprimer avec succès";
        }
        else{
            success = "Suppresion impossible!! Erreur!";
        }
        return success;
    }
    @GetMapping("/voitures/{num_serie}/{marque}/{prix}")
    public String Car_Create_or_Save(@PathVariable(value = "num_serie") String p_plateNumber,
                             @PathVariable(value = "marque") String p_brand, @PathVariable(value = "prix") int p_price) {
        String success;
        if(carrepo != null){
            carrepo.save(new Car(p_plateNumber,p_brand,p_price));
            success = "Voiture Créer or modifier avec succès";
        }
        else{
            success = "Création impossible!! Erreur!";
        }
        return success;
    }
}
