package edu.mondragon.riskFit;

import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

public class RiskFitApplicationTest {

    @Test
    public void testMainMethod() {
        try {
            RiskFitApplication.main(new String[] { "--spring.main.web-application-type=none" });
        } catch (Exception e) {
            fail("El método main lanzó una excepción: " + e.getMessage());
        }
    }

    @Test
    public void testRestTemplateBean() {
        RiskFitApplication application = new RiskFitApplication();
        RestTemplate restTemplate = application.restTemplate();
        assertNotNull(restTemplate, "El bean RestTemplate no debería ser nulo");
    }
}
