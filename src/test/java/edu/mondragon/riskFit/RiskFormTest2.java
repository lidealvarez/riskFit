package edu.mondragon.riskFit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import edu.mondragon.riskFit.Model.RiskFormModel2;

public class RiskFormTest2 {

    @Test
    public void testGetSetPlayerAge() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 0, 0, 0, 0, 0);

        int expectedAge = 25;
        riskFormModel2.setPlayer_Age(expectedAge);
        assertEquals(expectedAge, riskFormModel2.getPlayer_Age(), "La edad del jugador no se establece correctamente");
    }

    @Test
    public void testGetSetPlayerWeight() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(0, 70.5, 0, 0, 0, 0);

        double expectedWeight = 70.5;
        riskFormModel2.setPlayer_Weight(expectedWeight);
        assertEquals(expectedWeight, riskFormModel2.getPlayer_Weight(), "El peso del jugador no se establece correctamente");
    }

    @Test
    public void testGetSetPlayerHeight() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(0, 0, 180.2, 0, 0, 0);

        double expectedHeight = 180.2;
        riskFormModel2.setPlayer_Height(expectedHeight);
        assertEquals(expectedHeight, riskFormModel2.getPlayer_Height(), "La altura del jugador no se establece correctamente");
    }

    @Test
    public void testGetSetPreviousInjuries() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(0, 0, 0, 2, 0, 0);

        int expectedPreviousInjuries = 2;
        riskFormModel2.setPrevious_Injuries(expectedPreviousInjuries);
        assertEquals(expectedPreviousInjuries, riskFormModel2.getPrevious_Injuries(), "Las lesiones previas no se establecen correctamente");
    }

    @Test
    public void testGetSetTrainingIntensity() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(0, 0, 0, 0, 8, 0);

        int expectedIntensity = 8;
        riskFormModel2.setTraining_Intensity(expectedIntensity);
        assertEquals(expectedIntensity, riskFormModel2.getTraining_Intensity(), "La intensidad de entrenamiento no se establece correctamente");
    }

    @Test
    public void testGetSetRecoveryTime() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(0, 0, 0, 0, 0, 3);

        int expectedRecoveryTime = 3;
        riskFormModel2.setRecovery_Time(expectedRecoveryTime);
        assertEquals(expectedRecoveryTime, riskFormModel2.getRecovery_Time(), "El tiempo de recuperación no se establece correctamente");
    }
}
