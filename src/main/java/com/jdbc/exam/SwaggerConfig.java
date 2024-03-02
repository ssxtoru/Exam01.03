package com.jdbc.exam;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI configuration() {
        return new OpenAPI()
                .info(new Info()
                        .title("Exam01.03")
                        .description("Exam01.03")
                        .version("1.2.0")
                        .contact(new Contact().name("Altai")));
    }

}