package com.edanur.repository;

import com.edanur.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {


    Optional<Animal> findByNameAndSpeciesAndBreed (String name, String species, String breed);

    Optional<Animal> findByCustomerIdAndNameAndSpeciesAndBreed (Long customerId, String name, String species, String breed);

    List<Animal> findByName(String name);

    List<Animal> findByCustomerId(Long customerId);


    List<Animal> findByCustomerName(String customerName);



}
















    // istedigimiz kadar ozel sorgu ekleyebiliriz.
    // @Query("SELECT an FROM Animal an WHERE an.customer.name = :customerName")
    // @Query("SELECT an FROM Animal an WHERE an.customer.city = :city")







