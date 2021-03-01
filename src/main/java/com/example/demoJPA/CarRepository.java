package com.example.demoJPA;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

//le parametre de CRUD(CReate,Update,Delete) repository sont <la classe correspondant, type de la clé primaire de cette classe>
//Comme classe est Car ici alors son clé primaire est platenumber qui est un string
public interface CarRepository extends CrudRepository<Car, String> {
    List<Car> findByPlateNumberOrderByPriceDesc(String plateNumber);

    List<Car> findDistinctByBrand(String brand);

    List<Car> findByBrandAndPlateNumber(String brand, String plateNumber);

    @Query("SELECT c FROM Car c WHERE c.brand=:title and c.plateNumber=:category")
    List<Car> fetchCars(@Param("brand") String brand, @Param("plateNumber") String plateNumber);

}
