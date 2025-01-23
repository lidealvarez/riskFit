package edu.mondragon.riskFit.Controller;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Model.RiskFormModel2;
import edu.mondragon.riskFit.Service.RiskPredictionService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PredictController {

    private RiskPredictionService riskPredictionService;
    private static final String RISK_CATEGORY = "riskCategory";
    private static final String RISK_SCORE = "riskScore";
    private static final String ERROR = "error";

    @Autowired
    public PredictController(RiskPredictionService riskPredictionService) {
        this.riskPredictionService = riskPredictionService;
    }

    @GetMapping
    public String showIndex() {
        return "index";
    }

    @GetMapping("/predict")
    public String showPredictionForm(Model model) {
        model.addAttribute("riskForm", new RiskForm(0, 0, 0, 0, 0));
        return "predict";
    }

    @PostMapping("/predict")
    public String predict(@ModelAttribute RiskForm riskForm, Model model) {

        try {
            Map<String, Object> prediction = riskPredictionService.getRiskPrediction(riskForm);

            model.addAttribute(RISK_CATEGORY, prediction.get(RISK_CATEGORY));
            model.addAttribute(RISK_SCORE, prediction.get(RISK_SCORE));

            return "result";
        } catch (Exception e) {
            model.addAttribute(ERROR, "Ocurrió un error al procesar la predicción: " + e.getMessage());
            return ERROR;
        }
    }

    @GetMapping("/predict2")
    public String showPredictionForm2(Model model) {
        model.addAttribute("riskFormModel2", new RiskFormModel2(0, 0, 0, 0, 0, 0));
        return "predict2";
    }

    @PostMapping("/predict2")
    public String predict2(@ModelAttribute RiskFormModel2 riskFormModel2, Model model) {

        try {

            Map<String, Object> prediction = riskPredictionService.getRiskPrediction(riskFormModel2);

            model.addAttribute(RISK_CATEGORY, prediction.get(RISK_CATEGORY));
            model.addAttribute(RISK_SCORE, prediction.get(RISK_SCORE));

            return "result2";
        } catch (Exception e) {
            model.addAttribute(ERROR, "Ocurrió un error al procesar la predicción: " + e.getMessage());
            return ERROR;
        }
    }

    @GetMapping("/heart-rate")
    public String heartRatePage() {
        return "heartRate"; // El archivo HTML debe estar en src/main/resources/templates/
    }

}
