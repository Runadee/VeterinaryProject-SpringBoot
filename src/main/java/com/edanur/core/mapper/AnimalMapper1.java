package com.edanur.core.mapper;

import com.edanur.dto.request.AnimalRequest;
import com.edanur.dto.response.AnimalResponse;
import com.edanur.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface AnimalMapper1 {

    Animal asEntity(AnimalRequest animalRequest);
    AnimalResponse asOutput(Animal animal);
    List<AnimalResponse> asOutput(List<Animal> animalList);
    void update(@MappingTarget Animal entity, AnimalRequest animalRequest);

}
