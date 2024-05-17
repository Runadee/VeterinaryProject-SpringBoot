package com.edanur.core.mapper;

import com.edanur.dto.request.VaccineRequest;
import com.edanur.dto.response.VaccineResponse;
import com.edanur.entity.Vaccine;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VaccineMapper {

    Vaccine asEntity(VaccineRequest vaccineRequest);
    VaccineResponse asOutput (Vaccine vaccine);
    List<VaccineResponse> asOutput(List<Vaccine> vaccineList);
    void update(@MappingTarget Vaccine entity, VaccineRequest request);
}
