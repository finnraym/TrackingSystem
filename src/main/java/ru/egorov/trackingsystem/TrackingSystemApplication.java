package ru.egorov.trackingsystem;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class TrackingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackingSystemApplication.class, args);
    }

    @Bean
    public OpenAPI myOpenAPI() {
        Info info = new Info()
                .title("Tracking system api")
                .version("1.0")
                .description("This API provides endpoints for tracking time system.");
        return new OpenAPI()
                .info(info);
    }

}
