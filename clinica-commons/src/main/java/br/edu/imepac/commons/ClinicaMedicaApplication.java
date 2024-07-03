package br.edu.imepac.commons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"br.edu.imepac.commons", "br.edu.imepac.administrativo","br.edu.imepac.agendamento",
        "br.edu.imepac.atendimento"})
@ComponentScan(basePackages = {
        "br.edu.imepac.commons",
        "br.edu.imepac.administrativo",
        "br.edu.imepac.agendamento",
        "br.edu.imepac.atendimento"
})
public class ClinicaMedicaApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClinicaMedicaApplication.class, args);
    }
}