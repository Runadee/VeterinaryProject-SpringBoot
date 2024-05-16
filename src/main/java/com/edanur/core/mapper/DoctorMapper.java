package com.edanur.core.mapper;

import com.edanur.dto.request.DoctorRequest;
import com.edanur.dto.response.DoctorResponse;
import com.edanur.entity.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper
public interface DoctorMapper {

    Doctor asEntity(DoctorRequest doctorRequest);
    DoctorResponse asOutput(Doctor doctor);
    List<DoctorResponse> asOutput(List<Doctor> doctorList);
    void update(@MappingTarget Doctor entity, DoctorRequest request);
}
