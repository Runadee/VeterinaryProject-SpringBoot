package com.edanur.dto.request;

import com.edanur.entity.Animal;
import com.edanur.entity.Doctor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentRequest {
    private LocalDateTime appointmentDate;
    private Doctor doctor;
    private Animal animal;
}
