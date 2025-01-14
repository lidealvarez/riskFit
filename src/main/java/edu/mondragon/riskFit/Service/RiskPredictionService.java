package edu.mondragon.riskFit.Service;

import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import edu.mondragon.riskFit.Model.RiskForm;

import java.util.Map;

@Service
public class RiskPredictionService {

    String modelApiUrl = "http://localhost:5000/predict";

    private final RestTemplate restTemplate;

    public RiskPredictionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getRiskPrediction(RiskForm riskForm) {
        // Crear el cuerpo del request con los datos del formulario
        Map<String, Object> requestBody = Map.of(
                "Age", riskForm.getAge(),
                "Training_Hours_Per_Week", riskForm.getTrainingHoursPerWeek(),
                "Training_Intensity", riskForm.getTrainingIntensity(),
                "Weekly_Training_Volume", riskForm.getWeeklyTrainingVolume(),
                "Load_Progression", riskForm.getLoadProgression());
        System.out.println("Enviando datos al Model API: " + requestBody); // LOG DE DATOS ENVIADOS

        // Configurar las cabeceras
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Crear la solicitud HTTP
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Hacer la solicitud POST al Model API
        ResponseEntity<Map> response = restTemplate.exchange(
                modelApiUrl,
                HttpMethod.POST,
                entity,
                Map.class);
        System.out.println("Respuesta del Model API: " + response.getBody()); // LOG DE DATOS RECIBIDOS

        // Devolver el cuerpo de la respuesta
        return response.getBody();
    }
}
