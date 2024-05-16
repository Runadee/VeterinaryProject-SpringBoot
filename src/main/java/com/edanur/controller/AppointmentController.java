package com.edanur.controller;


import com.edanur.dto.request.AppointmentRequest;
import com.edanur.dto.response.AppointmentResponse;
import com.edanur.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/v1/appointments")
@RequiredArgsConstructor
public class AppointmentController {
    private final AppointmentService appointmentService;


    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findAll() {
        return appointmentService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse getById(@PathVariable("id") Long id) {
        return appointmentService.getById(id);
    }


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public AppointmentResponse save(@RequestBody AppointmentRequest appointment) {
        return appointmentService.create(appointment);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AppointmentResponse update(@PathVariable Long id, @RequestBody AppointmentRequest request) {
        return appointmentService.update(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        appointmentService.deleteById(id);
    }


    @GetMapping("/animalId")
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findByAppointmentDateBetweenAndAnimalId(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate,
            @RequestParam("animalId") Long animalId
    ) {
        return appointmentService.findByAppointmentDateBetweenAndAnimalId(startDate, endDate, animalId);
    }


    @GetMapping("/doctorId")
    @ResponseStatus(HttpStatus.OK)
    public List<AppointmentResponse> findByAppointmentDateBetweenAndDoctorId(
            @RequestParam("startDate") LocalDateTime startDate,
            @RequestParam("endDate") LocalDateTime endDate,
            @RequestParam("doctorId") Long doctorId
    ) {
        return appointmentService.findByAppointmentDateBetweenAndDoctorId(startDate, endDate, doctorId);
    }
}


