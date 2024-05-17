package com.edanur.core.mapper;

import com.edanur.dto.request.AppointmentRequest;
import com.edanur.dto.response.AppointmentResponse;
import com.edanur.entity.Appointment;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AppointmentMapper {
    Appointment asEntity(AppointmentRequest appointmentRequest);
    AppointmentResponse asOutput(Appointment appointment);
    List<AppointmentResponse> asOutput(List<Appointment> appointmentList);
    void update(@MappingTarget Appointment entity, AppointmentRequest appointmentRequest);


}
