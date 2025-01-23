package edu.mondragon.riskFit;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Model.RiskFormModel2;
import edu.mondragon.riskFit.Service.RiskPredictionService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Map;

public class RiskPredictionServiceTest {

    private RiskPredictionService riskPredictionService;
    private RestTemplate restTemplate;

    @BeforeEach
    void setUp() {
        restTemplate = mock(RestTemplate.class);
        riskPredictionService = new RiskPredictionService(restTemplate);
    }

    @Test
    void testGetRiskPredictionWithRiskForm() {
        RiskForm riskForm = new RiskForm(25, 10, 3, 5, 2);
        Map<String, Object> mockResponse = Map.of("risk", "low");

        when(restTemplate.exchange(
                eq("http://localhost:5000/predict"),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))
        ).thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

        Map<String, Object> response = riskPredictionService.getRiskPrediction(riskForm);

        assertEquals(mockResponse, response);

        verify(restTemplate, times(1)).exchange(
                eq("http://localhost:5000/predict"),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class)
        );
    }

    @Test
    void testGetRiskPredictionWithRiskFormModel2() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(30, 70.5, 175.2, 1, 5, 7);
        Map<String, Object> mockResponse = Map.of("risk", "medium");

        when(restTemplate.exchange(
                eq("http://localhost:5000/predict2"),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class))
        ).thenReturn(new ResponseEntity<>(mockResponse, HttpStatus.OK));

        Map<String, Object> response = riskPredictionService.getRiskPrediction(riskFormModel2);

        assertEquals(mockResponse, response);

        verify(restTemplate, times(1)).exchange(
                eq("http://localhost:5000/predict2"),
                eq(HttpMethod.POST),
                any(HttpEntity.class),
                any(ParameterizedTypeReference.class)
        );
    }
}
