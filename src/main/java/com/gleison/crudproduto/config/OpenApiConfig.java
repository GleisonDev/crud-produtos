package com.gleison.crudproduto.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Produtos - Portfolio Backend")
                        .description("CRUD de Produtos")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("Edilgleidson Silva")
                                .email("gleisondev5690@gmail.com")));
    }
}
