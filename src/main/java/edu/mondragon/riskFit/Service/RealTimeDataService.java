package edu.mondragon.riskFit.Service;

import edu.mondragon.riskFit.Model.RealTimeDataRequest;
import org.springframework.stereotype.Service;

@Service
public class RealTimeDataService {

    public void processRealTimeData(RealTimeDataRequest request) {
        // Procesar datos de frecuencia cardíaca
        System.out.println("Heart Rate: " + request.getHeartRate() + " at " + request.getHeartRateTimestamp());
        
        // Procesar datos de actividad
        System.out.println("Steps: " + request.getSteps() + ", Calories: " + request.getCaloriesBurned() + ", Distance: " + request.getDistance());
        
        // Procesar datos de sueño
        System.out.println("Sleep: " + request.getSleepQuality() + " from " + request.getSleepStartTime() + " to " + request.getSleepEndTime());
        
        // Aquí podrías guardar estos datos en base de datos, hacer cálculos adicionales, etc.
    }
}
