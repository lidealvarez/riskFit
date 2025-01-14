package edu.mondragon.riskFit;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RiskFitApplicationTest {

    @LocalServerPort
    private int port;

    @Test
    public void contextLoads() {
        // Si el contexto se carga correctamente, el método main será invocado
        // automáticamente durante el inicio de la aplicación.
        System.out.println("Aplicación iniciada en el puerto: " + port);
    }

}
