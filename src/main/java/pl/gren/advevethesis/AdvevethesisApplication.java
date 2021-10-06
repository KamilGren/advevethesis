package pl.gren.advevethesis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.gren.advevethesis.repository.UserRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class AdvevethesisApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdvevethesisApplication.class, args);
    }

}
