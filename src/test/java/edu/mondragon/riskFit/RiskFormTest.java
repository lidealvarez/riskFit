package edu.mondragon.riskFit;

import org.junit.jupiter.api.Test;

import edu.mondragon.riskFit.model.RiskForm;

import static org.junit.jupiter.api.Assertions.*;

public class RiskFormTest {

    @Test
    public void testGetSetAge() {
        RiskForm riskForm = new RiskForm(25, 0, 0, 0, 0);
        
        // Comprobar el setter y getter de age
        int expectedAge = 25;
        riskForm.setAge(expectedAge);
        assertEquals(expectedAge, riskForm.getAge(), "La edad no se establece correctamente");
    }

    @Test
    public void testGetSetTrainingHoursPerWeek() {
        RiskForm riskForm = new RiskForm(0, 5, 0, 0, 0);
        
        // Comprobar el setter y getter de trainingHoursPerWeek
        int expectedTrainingHours = 5;
        riskForm.setTrainingHoursPerWeek(expectedTrainingHours);
        assertEquals(expectedTrainingHours, riskForm.getTrainingHoursPerWeek(), "Las horas de entrenamiento por semana no se establecen correctamente");
    }

    @Test
    public void testGetSetTrainingIntensity() {
        RiskForm riskForm = new RiskForm(0, 0, 8, 0, 0);
        
        // Comprobar el setter y getter de trainingIntensity
        int expectedIntensity = 8;
        riskForm.setTrainingIntensity(expectedIntensity);
        assertEquals(expectedIntensity, riskForm.getTrainingIntensity(), "La intensidad de entrenamiento no se establece correctamente");
    }

    @Test
    public void testGetSetWeeklyTrainingVolume() {
        RiskForm riskForm = new RiskForm(0, 0, 0, 10, 0);
        
        // Comprobar el setter y getter de weeklyTrainingVolume
        int expectedVolume = 10;
        riskForm.setWeeklyTrainingVolume(expectedVolume);
        assertEquals(expectedVolume, riskForm.getWeeklyTrainingVolume(), "El volumen de entrenamiento semanal no se establece correctamente");
    }

    @Test
    public void testGetSetLoadProgression() {
        RiskForm riskForm = new RiskForm(0, 0, 0, 0, 1.2);
        
        // Comprobar el setter y getter de loadProgression
        double expectedLoadProgression = 1.2;
        riskForm.setLoadProgression(expectedLoadProgression);
        assertEquals(expectedLoadProgression, riskForm.getLoadProgression(), "La progresión de carga no se establece correctamente");
    }
}
