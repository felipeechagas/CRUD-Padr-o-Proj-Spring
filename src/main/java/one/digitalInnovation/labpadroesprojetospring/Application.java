package one.digitalInnovation.labpadroesprojetospring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Projeto Spring boot  gerado via spring Initializr.
 * Módulos selecionados:
 * - Spring Data Jpa
 * - Spring Web
 * - Lombok
 * - DevTools
 * - H2
 * - OpenFeigh
 *
 * @author Felipe Chagas
 */
@EnableFeignClients
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
