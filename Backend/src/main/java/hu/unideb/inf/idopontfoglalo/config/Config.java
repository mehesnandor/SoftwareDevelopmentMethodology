package hu.unideb.inf.idopontfoglalo.config;

import com.github.javafaker.Faker;
import hu.unideb.inf.idopontfoglalo.data.entity.FoglaltIdopontok;
import hu.unideb.inf.idopontfoglalo.data.repository.FoglaltIdopontokRepository;
import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Configuration
@Data
public class Config {


    private final FoglaltIdopontokRepository idopontokRepository;

    public Config(FoglaltIdopontokRepository idopontokRepository) {
        this.idopontokRepository = idopontokRepository;
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {

            FoglaltIdopontok idopontok = new FoglaltIdopontok();

            Faker faker = new Faker();

            LocalDateTime idopont;
            String nev;
            String email;
            String phoneNumber;

            for (int i = 0; i < 50; i++){

                idopont = faker.date().between(
                        Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()),
                        Date.from(LocalDateTime.now().plusMonths(2).atZone(ZoneId.systemDefault()).toInstant())
                ).toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

                nev = faker.name().fullName();
                email = faker.internet().emailAddress();
                phoneNumber = faker.regexify("(\\+\\d{1,3}[- ]?)?\\d{10}");

                idopontok.setId(null);
                idopontok.setNev(nev);
                idopontok.setIdopont(idopont);
                idopontok.setEmail(email);
                idopontok.setPhoneNumber(phoneNumber);

                idopontokRepository.save(
                    idopontok
                );
            }
        };
    }

}
