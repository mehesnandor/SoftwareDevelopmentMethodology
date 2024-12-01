package hu.unideb.inf.idopontfoglalo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class IdopontfoglaloApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdopontfoglaloApplication.class, args);
	}

}
