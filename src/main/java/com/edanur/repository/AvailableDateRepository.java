package com.edanur.repository;

import com.edanur.entity.AvailableDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AvailableDateRepository extends JpaRepository<AvailableDate, Long> {

    Optional<AvailableDate> findByAvailableDate (LocalDate availableDate);


    List<AvailableDate> findByDoctorId(Long doctorId);

    List<AvailableDate> findByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate);

    boolean existsByDoctorIdAndAvailableDate(Long doctorId, LocalDate availableDate);


}
