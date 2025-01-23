package edu.mondragon.riskFit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mondragon.riskFit.Model.RiskFormModel2;

public class RiskFormTest2 {

    @Test
    public void testConstructorAndGetters() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);

        assertEquals(25, riskFormModel2.getPlayer_Age());
        assertEquals(70.5, riskFormModel2.getPlayer_Weight());
        assertEquals(180.2, riskFormModel2.getPlayer_Height());
        assertEquals(2, riskFormModel2.getPrevious_Injuries());
        assertEquals(8, riskFormModel2.getTraining_Intensity());
        assertEquals(3, riskFormModel2.getRecovery_Time());
    }

    @Test
    public void testSetters() {
        RiskFormModel2 riskFormModel2 = new RiskFormModel2(25, 70.5, 180.2, 2, 8, 3);

        riskFormModel2.setPlayer_Age(30);
        riskFormModel2.setPlayer_Weight(75.0);
        riskFormModel2.setPlayer_Height(185.0);
        riskFormModel2.setPrevious_Injuries(3);
        riskFormModel2.setTraining_Intensity(9);
        riskFormModel2.setRecovery_Time(4);

        assertEquals(30, riskFormModel2.getPlayer_Age());
        assertEquals(75.0, riskFormModel2.getPlayer_Weight());
        assertEquals(185.0, riskFormModel2.getPlayer_Height());
        assertEquals(3, riskFormModel2.getPrevious_Injuries());
        assertEquals(9, riskFormModel2.getTraining_Intensity());
        assertEquals(4, riskFormModel2.getRecovery_Time());
    }
}