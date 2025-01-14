package edu.mondragon.riskFit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

class RiskFitApplicationTest {

    @Test
    void testMainMethod() {
        // Verifica que el método main no genere excepciones
        try {
            RiskFitApplication.main(new String[] { "--spring.main.web-application-type=none" });
        } catch (Exception e) {
            fail("El método main lanzó una excepción: " + e.getMessage());
        }
    }

    @Test
    void testRestTemplateBean() {
        // Verifica que el bean RestTemplate sea creado correctamente
        RiskFitApplication application = new RiskFitApplication();
        RestTemplate restTemplate = application.restTemplate();
        assertNotNull(restTemplate, "El bean RestTemplate no debería ser nulo");
    }
}
