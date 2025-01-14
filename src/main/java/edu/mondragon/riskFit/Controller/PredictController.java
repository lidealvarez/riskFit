package edu.mondragon.riskFit.Controller;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Service.RiskPredictionService;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PredictController {

    private RiskPredictionService riskPredictionService;

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

            model.addAttribute("riskCategory", prediction.get("riskCategory"));
            model.addAttribute("riskScore", prediction.get("riskScore"));

            return "result";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al procesar la predicción: " + e.getMessage());
            return "error";
        }
    }
}
