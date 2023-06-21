package com.spring.boot.app.wiproproject.config;





import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;





@Configuration
//@EnableSwagger2
public class APIConfig {
	
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}
	
	/*
	 * @Bean public Docket api() { return new
	 * Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any
	 * ()) .paths(PathSelectors.any()).build(); }
	 */
	

}
