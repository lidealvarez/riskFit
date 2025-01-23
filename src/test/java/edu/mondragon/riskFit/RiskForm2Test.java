package edu.mondragon.riskFit;

import org.junit.jupiter.api.Test;
import edu.mondragon.riskFit.Model.RiskFormModel2;
import static org.junit.jupiter.api.Assertions.*;

public class RiskForm2Test {

    @Test
    public void testGetPlayerAge() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        assertEquals(25, riskFormModel2.getPlayer_Age());
    }

    @Test
    public void testSetPlayerAge() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        riskFormModel2.setPlayer_Age(30);
        assertEquals(30, riskFormModel2.getPlayer_Age());
    }

    @Test
    public void testGetPlayerWeight() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        assertEquals(70.5, riskFormModel2.getPlayer_Weight());
    }

    @Test
    public void testSetPlayerWeight() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        riskFormModel2.setPlayer_Weight(75.0);
        assertEquals(75.0, riskFormModel2.getPlayer_Weight());
    }

    @Test
    public void testGetPlayerHeight() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        assertEquals(180.2, riskFormModel2.getPlayer_Height());
    }

    @Test
    public void testSetPlayerHeight() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        riskFormModel2.setPlayer_Height(185.0);
        assertEquals(185.0, riskFormModel2.getPlayer_Height());
    }

    @Test
    public void testGetPreviousInjuries() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        assertEquals(2, riskFormModel2.getPrevious_Injuries());
    }

    @Test
    public void testSetPreviousInjuries() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        riskFormModel2.setPrevious_Injuries(3);
        assertEquals(3, riskFormModel2.getPrevious_Injuries());
    }

    @Test
    public void testGetTrainingIntensity() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        assertEquals(8, riskFormModel2.getTraining_Intensity());
    }

    @Test
    public void testSetTrainingIntensity() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        riskFormModel2.setTraining_Intensity(9);
        assertEquals(9, riskFormModel2.getTraining_Intensity());
    }

    @Test
    public void testGetRecoveryTime() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        assertEquals(3, riskFormModel2.getRecovery_Time());
    }

    @Test
    public void testSetRecoveryTime() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);
        riskFormModel2.setRecovery_Time(4);
        assertEquals(4, riskFormModel2.getRecovery_Time());
    }
}
