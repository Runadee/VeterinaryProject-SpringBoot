package com.edanur.repository;

import com.edanur.entity.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface VaccineRepository extends JpaRepository<Vaccine, Long> {

    Optional<Vaccine> findByNameAndCode (String name, String code);
   // Optional<Vaccine> findByNameAndCodeAndStartDateAndEndDate (String name, String code);

    List<Vaccine> findByAnimalId(Long animalId);

    List<Vaccine> findByAnimalIdAndCodeAndProtectionFinishDateAfter(Long animalId, String code, LocalDate protectionStartDate);

    List<Vaccine> findByProtectionFinishDateBetween(LocalDate startDate, LocalDate endDate);

    Optional<Vaccine> findByAnimalIdAndNameAndCode(Long animalId, String name, String code);


}
