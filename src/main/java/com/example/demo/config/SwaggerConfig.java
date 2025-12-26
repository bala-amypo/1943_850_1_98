package com.example.demo.config;

import io.swagger.v3.oas.model.OpenAPI;
import io.swagger.v3.oas.model.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // You need to change the port as per your server
                .servers(List.of(
                        new Server().url("https://9244.408procr.amypo.ai/")
                ));
        } 
} 