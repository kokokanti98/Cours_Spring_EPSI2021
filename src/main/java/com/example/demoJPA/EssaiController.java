package com.example.demoJPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EssaiController {
    @Autowired
    private CarRepository carrepo;

    //Regarder tous les voitures au lancement de l'application la bdd est vide alors tout d'abord créer une bdd à l aide
    //de http://localhost:8088/voitures/create/1122AB/feri/2400 par exemple avant de lancer http://localhost:8088/voitures
    @GetMapping("/voitures")
    public List<Car> findAll() {

        var it = carrepo.findAll();

        var cars = new ArrayList<Car>();
        it.forEach(e -> cars.add(e));

        return cars;
    }
    //Pour supprimer par son numero de serie
    @GetMapping("/voitures/delete/{plateNumber}")
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
    //Pour voir par son numero de serie
    @GetMapping("/voitures/{plateNumber}")
    public Optional<Car> Car_SeeById(@PathVariable(value = "plateNumber") String p_plateNumber) {
        var it = carrepo.findById(p_plateNumber);
        if(it!=null){
            System.out.println("La voiture existe et trouvé dans le navigateur web!");
        }
        else{
            System.out.println("La voiture n'existe pas donc la valeur trouvé est null");
        }
        return it;
    }
    //Pour créer une voiture
    @GetMapping("/voitures/create/{num_serie}/{marque}/{prix}")
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
