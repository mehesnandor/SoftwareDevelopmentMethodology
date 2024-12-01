package hu.unideb.inf.idopontfoglalo.config;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
public class Config {

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

        };
    }

}
