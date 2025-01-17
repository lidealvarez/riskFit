package edu.mondragon.riskFit.Service;

import org.springframework.stereotype.Service;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Model.RiskFormModel2;

import java.util.Map;

@Service
public class RiskPredictionService {

    String modelApiUrl = "http://localhost:5000/predict";
    String modelApiUrl2 = "http://localhost:5000/predict2";

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

    public Map<String, Object> getRiskPrediction(RiskFormModel2 riskFormModel2) {
        
        System.out.println("\nSERVICE");
        System.out.println("player_Age: " + riskFormModel2.getPlayer_Age());
        System.out.println("player_Weight: " + riskFormModel2.getPlayer_Weight());
        System.out.println("player_Height: " + riskFormModel2.getPlayer_Height());
        System.out.println("previous_Injuries: " + riskFormModel2.getPrevious_Injuries());
        System.out.println("training_Intensity: " + riskFormModel2.getTraining_Intensity());
        System.out.println("recovery_Time: " + riskFormModel2.getRecovery_Time());
        Map<String, Object> requestBody = Map.of(
                "Player_Age", riskFormModel2.getPlayer_Age(),
                "Player_Weight", riskFormModel2.getPlayer_Weight(),
                "Player_Height", riskFormModel2.getPlayer_Height(),
                "Previous_Injuries", riskFormModel2.getPrevious_Injuries(),
                "Training_Intensity", riskFormModel2.getTraining_Intensity(),
                "Recovery_Time", riskFormModel2.getRecovery_Time());

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        ResponseEntity<Map> response = restTemplate.exchange(
                modelApiUrl2,
                HttpMethod.POST,
                entity,
                Map.class);
        System.out.println("Response body: " + response.getBody());

        return response.getBody();
    }
}
