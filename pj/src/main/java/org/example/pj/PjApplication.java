package org.example.pj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PjApplication {

    public static void main(String[] args) {
        SpringApplication.run(PjApplication.class, args);
    }

}
