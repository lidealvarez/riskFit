package edu.mondragon.riskFit.Service;

import edu.mondragon.riskFit.Model.RiskForm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RiskPredictionService {

    @Value("${flask.api.url}")
    private String flaskApiUrl;  // URL de la API Flask

    private final RestTemplate restTemplate;

    // Constructor para inyectar RestTemplate
    public RiskPredictionService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    /**
     * Método para obtener la predicción de riesgo desde la API Flask.
     *
     * @param riskForm El formulario con las características de entrada
     * @return La predicción obtenida desde Flask
     */
    public Map<String, Object> getRiskPrediction(RiskForm riskForm) {
        // Crear un Map con las características del formulario
        Map<String, Object> requestBody = Map.of(
                "age", riskForm.getAge(),
                "trainingHoursPerWeek", riskForm.getTrainingHoursPerWeek(),
                "trainingIntensity", riskForm.getTrainingIntensity(),
                "weeklyTrainingVolume", riskForm.getWeeklyTrainingVolume(),
                "loadProgression", riskForm.getLoadProgression()
        );

        // Crear cabeceras para la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");

        // Crear una entidad HTTP con las cabeceras y los datos del cuerpo
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(requestBody, headers);

        // Realizar la solicitud POST a la API Flask y recibir la respuesta
        ResponseEntity<Map> response = restTemplate.exchange(
                flaskApiUrl, // URL de la API Flask
                HttpMethod.POST, // Método POST
                entity, // Entidad con el cuerpo de la solicitud
                Map.class // Tipo de respuesta esperado
        );

        // Devolver el cuerpo de la respuesta (predicción)
        return response.getBody();
    }
}
