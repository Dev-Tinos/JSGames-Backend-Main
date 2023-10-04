package com.example.jsgamesbackendmain.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        List<Server> objects = new ArrayList<>();
        objects.add(new Server().url("/"));
        return new OpenAPI().servers(objects)
                .info(new Info()
                        .title("DevHive API")
                        .version("1.0")
                        .description("Base URL: /"));
    }
}