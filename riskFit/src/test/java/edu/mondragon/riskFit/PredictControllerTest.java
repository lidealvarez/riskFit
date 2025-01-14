package edu.mondragon.riskFit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import edu.mondragon.riskFit.Model.RiskForm;
import edu.mondragon.riskFit.Service.RiskPredictionService;

@SpringBootTest
@AutoConfigureMockMvc
public class PredictControllerTest {

        @Autowired
        private MockMvc mockMvc;

        // Mock del servicio RiskPredictionService
        @SuppressWarnings("removal")
        @MockBean
        private RiskPredictionService riskPredictionService;

        @Test
        public void testShowIndex() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/"))
                                .andExpect(MockMvcResultMatchers.status().isOk()) // Verifica que la respuesta sea 200
                                                                                  // OK
                                .andExpect(MockMvcResultMatchers.view().name("index")); // Verifica que la vista sea
                                                                                        // "index"
        }

        @Test
        public void testPredictEndpoint() throws Exception {
                mockMvc.perform(MockMvcRequestBuilders.get("/predict"))
                                .andExpect(MockMvcResultMatchers.status().isOk()) // Verifica que la respuesta es OK
                                                                                  // (200)
                                .andExpect(MockMvcResultMatchers.view().name("predict")); // Verifica que la vista
                                                                                          // retornada es "predict"
        }

        @Test
        public void testPostPrediction() throws Exception {
                // Configura el mock para devolver un valor simulado
                when(riskPredictionService.getRiskPrediction(any(RiskForm.class)))
                                .thenReturn(Map.of("riskCategory", "Alto", "riskScore", 0.9323214285714284));

                String jsonInput = "{\"Age\":1,\"Training_Hours_Per_Week\":2,\"Training_Intensity\":3,\"Weekly_Training_Volume\":3,\"Load_Progression\":5.0}";

                mockMvc.perform(MockMvcRequestBuilders.post("/predict")
                                .contentType("application/json")
                                .content(jsonInput))
                                .andExpect(MockMvcResultMatchers.status().isOk()) // Verifica que la respuesta es OK
                                                                                  // (200)
                                .andExpect(MockMvcResultMatchers.view().name("result")) // Verifica que la vista
                                                                                        // retornada es "result"
                                .andExpect(MockMvcResultMatchers.model().attributeExists("riskCategory"))
                                .andExpect(MockMvcResultMatchers.model().attributeExists("riskScore"));
        }

        @Test
        public void testPredictWithError() throws Exception {
                // Configura el mock para lanzar una excepción cuando se llame al servicio
                when(riskPredictionService.getRiskPrediction(any(RiskForm.class)))
                                .thenThrow(new RuntimeException("Error al procesar la predicción"));

                // Datos de prueba para el formulario
                String jsonInput = "{\"Age\":1,\"Training_Hours_Per_Week\":2,\"Training_Intensity\":3,\"Weekly_Training_Volume\":3,\"Load_Progression\":5.0}";

                mockMvc.perform(MockMvcRequestBuilders.post("/predict")
                                .contentType("application/json")
                                .content(jsonInput))
                                .andExpect(MockMvcResultMatchers.status().isOk()) // Verifica que la respuesta es OK
                                .andExpect(MockMvcResultMatchers.view().name("error")) // Verifica que la vista es
                                                                                       // "error"
                                .andExpect(MockMvcResultMatchers.model().attribute("error",
                                                "Ocurrió un error al procesar la predicción: Error al procesar la predicción")); // Verifica
                                                                                                                                 // que
                                                                                                                                 // el
                                                                                                                                 // mensaje
                                                                                                                                 // de
                                                                                                                                 // error
                                                                                                                                 // esté
                                                                                                                                 // en
                                                                                                                                 // el
                                                                                                                                 // modelo
        }
}
