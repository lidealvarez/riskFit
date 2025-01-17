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

            model.addAttribute("riskCategory", prediction.get("riskCategory"));
            model.addAttribute("riskScore", prediction.get("riskScore"));

            return "result";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al procesar la predicción: " + e.getMessage());
            return "error";
        }
    }

    @GetMapping("/predict2")
    public String showPredictionForm2(Model model) {
        model.addAttribute("riskFormModel2", new RiskFormModel2(0, 0, 0, 0, 0, 0));
        return "predict2";
    }

    @PostMapping("/predict2")
    public String predict2(@ModelAttribute RiskFormModel2 riskFormModel2, Model model) {

        System.out.println("\nCONTROLLER");
        System.out.println("player_Age: " + riskFormModel2.getPlayer_Age());
        System.out.println("player_Weight: " + riskFormModel2.getPlayer_Weight());
        System.out.println("player_Height: " + riskFormModel2.getPlayer_Height());
        System.out.println("previous_Injuries: " + riskFormModel2.getPrevious_Injuries());
        System.out.println("training_Intensity: " + riskFormModel2.getTraining_Intensity());
        System.out.println("recovery_Time: " + riskFormModel2.getRecovery_Time());
        try {

            Map<String, Object> prediction = riskPredictionService.getRiskPrediction(riskFormModel2);

            model.addAttribute("riskCategory", prediction.get("riskCategory"));
            model.addAttribute("riskScore", prediction.get("riskScore"));

            return "result2";
        } catch (Exception e) {
            model.addAttribute("error", "Ocurrió un error al procesar la predicción: " + e.getMessage());
            return "error";
        }
    }
}
