package edu.mondragon.riskFit.service;

import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import edu.mondragon.riskFit.model.RiskForm;

import java.util.Map;

@Service
public class RiskPredictionService {

    String modelApiUrl = "http://localhost:5000/predict";

    private final RestTemplate restTemplate;

    public RiskPredictionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, Object> getRiskPrediction(RiskForm riskForm) {
        Map<String, Object> requestBody = Map.of(
                "Age", riskForm.getAge(),
                "Training_Hours_Per_Week", riskForm.getTrainingHoursPerWeek(),
                "Training_Intensity", riskForm.getTrainingIntensity(),
                "Weekly_Training_Volume", riskForm.getWeeklyTrainingVolume(),
                "Load_Progression", riskForm.getLoadProgression());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                modelApiUrl,
                HttpMethod.POST,
                entity,
                Map.class);

        return response.getBody();
    }
}
