package edu.mondragon.riskFit.Controller;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Service.RiskPredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/predict")
public class PredictController {

    private final RiskPredictionService riskPredictionService;

    // Constructor para inyectar el servicio
    @Autowired
    public PredictController(RiskPredictionService riskPredictionService) {
        this.riskPredictionService = riskPredictionService;
    }

    @PostMapping
    public Map<String, Object> getPrediction(@RequestBody RiskForm riskForm) {
        // Usamos el servicio para obtener la predicción
        return riskPredictionService.getRiskPrediction(riskForm);
    }
}
