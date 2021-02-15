package com.example.demoJPA;

import org.springframework.data.repository.Repository;

import org.springframework.data.repository.CrudRepository;
//@Repository
public interface CarRepository extends CrudRepository<Car, String> {

}
