package com.example.demoJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EssaiController {
    //retoureve moi CardRepository et donne moi accès
    @Autowired
    private CarRepository carrepo;

    //Regarder tous les voitures au lancement de l'application la bdd est vide alors tout d'abord créer une bdd à l aide
    //de http://localhost:8088/voitures/create/1122AB/feri/2400 par exemple avant de lancer http://localhost:8088/voitures
    @GetMapping("/voitures")
    @ResponseBody
    public List<Car> findAll() {

        var it = carrepo.findAll();

        var cars = new ArrayList<Car>();
        it.forEach(e -> cars.add(e));

        return cars;
    }
    @GetMapping("/voitures")
    @ResponseBody
    public List<Car> findByPlateNumberOrderByPriceDesc(@RequestParam String plateNumber) {

        var it = carrepo.findByPlateNumberOrderByPriceDesc(plateNumber);

        var cars = new ArrayList<Car>();
        it.forEach(e -> cars.add(e));

        return cars;
    }
    //@RequestHeader("my-number")
    //@RequestParam String p_plateNumber
    //Appel HTTP GET via param
    @GetMapping(value = "/voiture")
    @ResponseBody
    public Optional<Car> Car_SeeByIds(@RequestParam String plateNumber) {
        var it = carrepo.findById(plateNumber);
        if(it == null){
            System.out.println("La voiture n'existe pas donc la valeur trouvé est null");
        }
        else{
            System.out.println("La voiture existe et trouvé dans le navigateur web!");
        }
        return it;
    }
    //n oublier pas de mettre dans headers dans postman le Content-type et value = application/json
    // et dans body la valeur de chaque ligne(ligne pour les donnees pour creer la classe car) en json bien sur
    //{
    //    "plateNumber" : "A16X22E",
    //        "brand" : "ferrari",
    //        "price" : 14000
    //}
    //creer une voiture a l aide d un fichier json
    @PostMapping(value = "/voitures/creer")
    @ResponseBody
    public  Car Car_CreatOrModify(@RequestBody Car car_created) {
        Car voiture_enregistrer = carrepo.save(car_created);
        if(carrepo != null){
            System.out.println("Voiture creer avec succès");
        }
        else{
            System.out.println("Creation impossible!! Erreur!");
        }
        return voiture_enregistrer;
    }
    //n oublier pas de mettre dans headers dans postman le Content-type et value = application/json
    // et dans body la valeur de chaque ligne(ligne pour les donnees pour creer la classe car) en json bien sur
    //{
    //    "plateNumber" : "A16X22E",
    //        "brand" : "ferrari",
    //        "price" : 14000
    //}
    //supprimer une voiture a l aide d un fichier json
    @DeleteMapping(value = "/voitures/supprimer")
    @ResponseBody
    public  void  Car_Delete(@RequestBody Car car_created) {
        if(carrepo != null){
            carrepo.deleteById(car_created.getPlateNumber());
            System.out.println("Voiture supprimer avec succès");
        }
        else{
            System.out.println("Suppresion impossible!! Erreur!");
        }
    }
    //Pour créer une voiture avec juste les liens
    //n oublier pas de préciser sur Postman que le lien URI ici est en POST
    @PostMapping("/voitures/creer/{num_serie}/{marque}/{prix}")
    @ResponseBody
    public  Car Car_Create_or_Save(@PathVariable(value = "num_serie") String p_plateNumber,
                                   @PathVariable(value = "marque") String p_brand, @PathVariable(value = "prix") int p_price) {
        Car voiture_enregistrer = carrepo.save(new Car(p_plateNumber,p_brand,p_price));
        return voiture_enregistrer;
    }

    //Pour voir par son numero de serie âr requete http GET
    @GetMapping("/voitures/{plateNumber}")
    @ResponseBody
    public Optional<Car> Car_SeeById(@PathVariable(value = "plateNumber") String p_plateNumber) {
        var it = carrepo.findById(p_plateNumber);
        if(it == null){
            System.out.println("La voiture n'existe pas donc la valeur trouvé est null");
        }
        else{
            System.out.println("La voiture existe et trouvé dans le navigateur web!");
        }
        return it;
    }
    //Pour supprimer une voiture par son numero de serie grace à un adresse http DELETE
    //n oublier pas de préciser sur Postman que le lien URI ici est en DELETE A12EDRD
    @DeleteMapping("/voitures/{plateNumber}")
    @ResponseBody
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
}
