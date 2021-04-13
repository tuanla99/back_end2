package com.it5420.api.config;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI(){
        Server server = new Server();
        List<Server> servers = new ArrayList<>();
        server.url("http://localhost:8082") ;
        servers.add(server) ;
        return new OpenAPI()
                // Thiết lập các server dùng để test api
                .servers( servers)
                .info(new Info().title(" API Data Integration")
                                .description("API do nhóm phát triển")
                                .contact(new Contact().name("Hust"))
                                .license(new License()
                                        .name("Apache 2.0")
                                        .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                                .version("1.0.0"));

    }
}
