package edu.mondragon.riskFit;

import edu.mondragon.riskFit.controller.PredictController;
import edu.mondragon.riskFit.model.RiskForm;
import edu.mondragon.riskFit.service.RiskPredictionService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

class PredictControllerTest {

    @InjectMocks
    private PredictController predictController;

    @Mock
    private RiskPredictionService riskPredictionService;

    @Mock
    private Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testShowIndex() {
        // Act
        String viewName = predictController.showIndex();

        // Assert
        assertEquals("index", viewName);
    }

    @Test
    void testShowPredictionForm() {
        // Act
        String viewName = predictController.showPredictionForm(model);

        // Assert
        verify(model).addAttribute(eq("riskForm"), any(RiskForm.class));
        assertEquals("predict", viewName);
    }

    @Test
    void testPredict_Success() {
        // Arrange
        RiskForm riskForm = new RiskForm(1, 2, 3, 4, 5);
        Map<String, Object> prediction = new HashMap<>();
        prediction.put("riskCategory", "Medium");
        prediction.put("riskScore", 0.65);

        when(riskPredictionService.getRiskPrediction(riskForm)).thenReturn(prediction);

        // Act
        String viewName = predictController.predict(riskForm, model);

        // Assert
        verify(riskPredictionService).getRiskPrediction(riskForm);
        verify(model).addAttribute("riskCategory", "Medium");
        verify(model).addAttribute("riskScore", 0.65);
        assertEquals("result", viewName);
    }

    @Test
    void testPredict_Error() {
        // Arrange
        RiskForm riskForm = new RiskForm(1, 2, 3, 4, 5);
        when(riskPredictionService.getRiskPrediction(riskForm)).thenThrow(new RuntimeException("Service error"));

        // Act
        String viewName = predictController.predict(riskForm, model);

        // Assert
        verify(riskPredictionService).getRiskPrediction(riskForm);
        verify(model).addAttribute("error", "Ocurrió un error al procesar la predicción: Service error");
        assertEquals("error", viewName);
    }
}
