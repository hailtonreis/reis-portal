package com.hailton.reis_portal.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI reisPortalOpenAPI() {
		
		return new OpenAPI()
				.info(
						new Info()
								.title("Reis Portal API")
								.description(
										"API responsável pela autenticação, autorização e gerenciamento do Reis Portal."
										)
								.version("v1.0.0")
						);	
	}

}
