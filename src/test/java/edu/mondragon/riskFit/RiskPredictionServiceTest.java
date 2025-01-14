package edu.mondragon.riskFit;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Service.RiskPredictionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mockito;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

public class RiskPredictionServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private RiskPredictionService riskPredictionService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    public void testGetRiskPrediction_Success() {
        // Preparar el objeto de entrada
        RiskForm riskForm = new RiskForm(25, 10, 7, 70, 5.0); // Usa datos de ejemplo

        // Preparar la respuesta simulada
        Map<String, Object> mockedResponse = Map.of("predicted_risk", 0.75);
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(mockedResponse, HttpStatus.OK);

        // Configurar el mock de restTemplate para devolver la respuesta simulada
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), Mockito.any(HttpEntity.class), Mockito.eq(Map.class)))
                .thenReturn(responseEntity);

        // Llamar al método
        Map<String, Object> response = riskPredictionService.getRiskPrediction(riskForm);

        // Verificar la respuesta
        assertNotNull(response);
        assertEquals(0.75, response.get("predicted_risk"));
    }

    @Test
    public void testGetRiskPrediction_Failure() {
        // Preparar el objeto de entrada
        RiskForm riskForm = new RiskForm(25, 10, 7, 70, 5.0);

        // Configurar la respuesta simulada con un error
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        // Configurar el mock de restTemplate para devolver el error
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), Mockito.any(HttpEntity.class), Mockito.eq(Map.class)))
                .thenReturn(responseEntity);

        // Llamar al método
        Map<String, Object> response = riskPredictionService.getRiskPrediction(riskForm);

        // Verificar que la respuesta es null debido al error en la API
        assertNull(response);
    }

    @Test
    public void testGetRiskPrediction_EmptyResponse() {
        // Preparar el objeto de entrada
        RiskForm riskForm = new RiskForm(25, 10, 7, 70, 5.0);

        // Configurar la respuesta simulada con cuerpo vacío
        Map<String, Object> mockedResponse = Map.of();
        ResponseEntity<Map> responseEntity = new ResponseEntity<>(mockedResponse, HttpStatus.OK);

        // Configurar el mock de restTemplate para devolver la respuesta simulada
        Mockito.when(restTemplate.exchange(Mockito.anyString(), Mockito.eq(HttpMethod.POST), Mockito.any(HttpEntity.class), Mockito.eq(Map.class)))
                .thenReturn(responseEntity);

        // Llamar al método
        Map<String, Object> response = riskPredictionService.getRiskPrediction(riskForm);

        // Verificar que la respuesta está vacía
        assertTrue(response.isEmpty());
    }
}
