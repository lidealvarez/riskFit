package edu.mondragon.riskFit;

import org.junit.jupiter.api.Test;

import edu.mondragon.riskFit.Model.RiskPredictionResponse;

import static org.junit.jupiter.api.Assertions.*;

public class RiskPredictionTest {

    @Test
    public void testGetSetRiskCategory() {
        RiskPredictionResponse response = new RiskPredictionResponse();
        
        // Comprobar el setter y getter de riskCategory
        String expectedCategory = "Alto";
        response.setRiskCategory(expectedCategory);
        assertEquals(expectedCategory, response.getRiskCategory(), "El riskCategory no se establece correctamente");
    }

    @Test
    public void testGetSetRiskScore() {
        RiskPredictionResponse response = new RiskPredictionResponse();
        
        // Comprobar el setter y getter de riskScore
        double expectedScore = 0.85;
        response.setRiskScore(expectedScore);
        assertEquals(expectedScore, response.getRiskScore(), "El riskScore no se establece correctamente");
    }
}
