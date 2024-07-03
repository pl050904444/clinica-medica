package br.edu.imepac.administrativo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"br.edu.imepac.administrativo", "br.edu.imepac.commons"})
@EnableJpaRepositories(basePackages = {"br.edu.imepac.commons.repository"})
public class AdministrativoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdministrativoApplication.class, args);
    }
}