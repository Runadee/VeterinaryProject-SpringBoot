package com.edanur.core.mapper;

import com.edanur.dto.request.AnimalRequest;
import com.edanur.dto.response.AnimalResponse;
import com.edanur.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AnimalMapper {

    Animal asEntity(AnimalRequest animalRequest);
    AnimalResponse asOutput(Animal animal);
    List<AnimalResponse> asOutput(List<Animal> animalList);
    void update(@MappingTarget Animal entity, AnimalRequest animalRequest);

}
