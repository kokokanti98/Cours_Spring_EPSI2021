package com.example.demoJPA;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

//le parametre de CRUD(CReate,Update,Delete) repository sont <la classe correspondant, type de la clé primaire de cette classe>
//Comme classe est Car ici alors son clé primaire est platenumber qui est un string
public interface CarRepository extends CrudRepository<Car, String> {
    List<Car> findByBrandOrderByPriceDesc(String brand);

    List<Car> findDistinctByBrand(String brand);

    Optional<Car> findByBrandAndPlateNumber(String brand, String plateNumber);

    List<Car> findByOrderByPlateNumberAsc();

    @Query("SELECT c FROM Car c WHERE c.brand=:brand and c.price=:price")
    List<Car> fetchCarByBrandAndPrice(@Param("brand") String brand, @Param("price") int price);

}
