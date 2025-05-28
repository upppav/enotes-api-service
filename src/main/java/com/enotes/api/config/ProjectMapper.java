package com.enotes.api.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProjectMapper {
@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
		
	}


}
