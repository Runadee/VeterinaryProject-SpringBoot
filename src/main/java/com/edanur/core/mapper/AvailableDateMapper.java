package com.edanur.core.mapper;

import com.edanur.dto.request.AvailableDateRequest;
import com.edanur.dto.response.AvailableDateResponse;
import com.edanur.entity.AvailableDate;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AvailableDateMapper {

    AvailableDate asEntity(AvailableDateRequest availableDateRequest);
    AvailableDateResponse asOutput(AvailableDate availableDate);
    List<AvailableDateResponse> asOutput(List<AvailableDate> availableDateList);
    void update(@MappingTarget AvailableDate entity, AvailableDateRequest request);



}
