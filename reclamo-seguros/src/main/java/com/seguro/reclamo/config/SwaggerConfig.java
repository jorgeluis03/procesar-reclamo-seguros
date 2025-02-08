package com.seguro.reclamo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() { //http://localhost:8083/swagger-ui/index.html
        return new OpenAPI()
                .info(new Info()
                        .title("API Reclamos de Seguros")
                        .version("1.0"));
    }
}
