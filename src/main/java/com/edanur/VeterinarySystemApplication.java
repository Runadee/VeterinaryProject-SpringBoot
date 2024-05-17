package com.edanur;

import com.edanur.core.mapper.AnimalMapper1;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VeterinarySystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(VeterinarySystemApplication.class, args);
	}


}
