package edu.mondragon.riskFit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import edu.mondragon.riskFit.Controller.PredictController;
import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Model.RiskFormModel2;
import edu.mondragon.riskFit.Service.RiskPredictionService;

public class PredictControllerTest {

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
    public void testShowIndex() {
        // Act
        String viewName = predictController.showIndex();

        // Assert
        assertEquals("index", viewName);
    }

    @Test
    public void testShowPredictionForm() {
        // Act
        String viewName = predictController.showPredictionForm(model);

        // Assert
        verify(model).addAttribute(eq("riskForm"), any(RiskForm.class));
        assertEquals("predict", viewName);
    }

    @Test
    public void testPredict_Success() {
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
    public void testPredict_Error() {
        RiskForm riskForm = new RiskForm(1, 2, 3, 4, 5);
        when(riskPredictionService.getRiskPrediction(riskForm)).thenThrow(new RuntimeException("Service error"));

        String viewName = predictController.predict(riskForm, model);

        verify(riskPredictionService).getRiskPrediction(riskForm);
        verify(model).addAttribute("error", "Ocurrió un error al procesar la predicción: Service error");
        assertEquals("error", viewName);
    }

    @Test
    public void testShowPredictionForm2() {
        String viewName = predictController.showPredictionForm2(model);
        verify(model).addAttribute(eq("riskFormModel2"), any(RiskFormModel2.class));
        assertEquals("predict2", viewName);
    }

    @Test
    public void testPredict2_Success() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(1, 2, 3, 4, 5, 6);
        Map<String, Object> prediction = new HashMap<>();
        prediction.put("riskCategory", "High");
        prediction.put("riskScore", 0.85);

        when(riskPredictionService.getRiskPrediction(riskFormModel2)).thenReturn(prediction);

        String viewName = predictController.predict2(riskFormModel2, model);

        verify(riskPredictionService).getRiskPrediction(riskFormModel2);
        verify(model).addAttribute("riskCategory", "High");
        verify(model).addAttribute("riskScore", 0.85);
        assertEquals("result2", viewName);
    }

    @Test
    public void testPredict2_Error() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(1, 2, 3, 4, 5, 6);
        when(riskPredictionService.getRiskPrediction(riskFormModel2)).thenThrow(new RuntimeException("Service error"));

        String viewName = predictController.predict2(riskFormModel2, model);

        verify(riskPredictionService).getRiskPrediction(riskFormModel2);
        verify(model).addAttribute("error", "Ocurrió un error al procesar la predicción: Service error");
        assertEquals("error", viewName);
    }

   
    
}
