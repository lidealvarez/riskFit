package edu.mondragon.riskFit.Controller;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Service.RiskPredictionService;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class PredictController {

    @Autowired
    private RiskPredictionService riskPredictionService;

    @GetMapping
    public String showIndex() {
        return "index"; // Muestra el HTML de inicio
    }

    @GetMapping("/predict")
    public String showPredictionForm(Model model) {
        model.addAttribute("riskForm", new RiskForm());
        return "predict"; // Muestra el formulario
    }

    @PostMapping("/predict")
    public String predict(@ModelAttribute RiskForm riskForm, Model model) {
        try {
            // Llamar al servicio para obtener la predicción
            Map<String, Object> prediction = riskPredictionService.getRiskPrediction(riskForm);

            System.out.println("Predicción obtenida del Model API: " + prediction); // LOG DE PREDICCIÓN

            // Añadir los resultados al modelo para mostrarlos en el HTML
            model.addAttribute("riskCategory", prediction.get("riskCategory"));
            model.addAttribute("riskScore", prediction.get("riskScore"));
            System.out.println("\nCategoría de riesgo: " + prediction.get("riskCategory"));
            System.out.println("\nPuntuación de riesgo: " + prediction.get("riskScore"));


            return "result"; // Renderiza el result.html
        } catch (Exception e) {
            System.out.println("Error al procesar la predicción: " + e.getMessage()); // LOG DE ERROR
            model.addAttribute("error", "Ocurrió un error al procesar la predicción: " + e.getMessage());
            return "error"; // Renderiza el error.html
        }
    }
}
