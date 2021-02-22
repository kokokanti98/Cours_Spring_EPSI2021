package com.example.demoJPA;

import org.springframework.data.repository.Repository;

import org.springframework.data.repository.CrudRepository;
//le parametre de CRUD(CReate,Update,Delete) repository sont <la classe correspondant, type de la clé primaire de cette classe>
//Comme classe est Car ici alors son clé primaire est platenumber qui est un string
public interface CarRepository extends CrudRepository<Car, String> {

}
