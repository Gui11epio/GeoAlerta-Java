package br.com.fiap.geoalerta;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//http://localhost:8080/swagger-ui/index.html#/

@OpenAPIDefinition(
        info = @Info(
                title = "GeoAlerta",
                version = "1.0",
                description = "Documentação da API para o alerta de deslizamento"
        )
)

@SpringBootApplication
public class GeoAlertaApplication {

    public static void main(String[] args) {
        SpringApplication.run(GeoAlertaApplication.class, args);
    }

    @Configuration
    public class ModelMapperConfig {
        @Bean
        public ModelMapper modelMapper() {
            return new ModelMapper();
        }
    }

}
