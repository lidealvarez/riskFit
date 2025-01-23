package edu.mondragon.riskFit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.mondragon.riskFit.Model.RiskFormModel2;

public class RiskFormTest2 {

    private RiskFormModel2 riskFormModel2;

    @BeforeEach
    public void setUp() {
        // Inicializa un objeto de prueba antes de cada test
        riskFormModel2 = new RiskFormModel2(25, 75.5, 180.2, 2, 4, 3);
    }

    @Test
    public void testGetPlayer_Age() {
        assertEquals(25, riskFormModel2.getPlayer_Age());
    }

    @Test
    public void testSetPlayer_Age() {
        riskFormModel2.setPlayer_Age(30);
        assertEquals(30, riskFormModel2.getPlayer_Age());
    }

    @Test
    public void testGetPlayer_Weight() {
        assertEquals(75.5, riskFormModel2.getPlayer_Weight());
    }

    @Test
    public void testSetPlayer_Weight() {
        riskFormModel2.setPlayer_Weight(80.0);
        assertEquals(80.0, riskFormModel2.getPlayer_Weight());
    }

    @Test
    public void testGetPlayer_Height() {
        assertEquals(180.2, riskFormModel2.getPlayer_Height());
    }

    @Test
    public void testSetPlayer_Height() {
        riskFormModel2.setPlayer_Height(185.5);
        assertEquals(185.5, riskFormModel2.getPlayer_Height());
    }

    @Test
    public void testGetPrevious_Injuries() {
        assertEquals(2, riskFormModel2.getPrevious_Injuries());
    }

    @Test
    public void testSetPrevious_Injuries() {
        riskFormModel2.setPrevious_Injuries(5);
        assertEquals(5, riskFormModel2.getPrevious_Injuries());
    }

    @Test
    public void testGetTraining_Intensity() {
        assertEquals(4, riskFormModel2.getTraining_Intensity());
    }

    @Test
    public void testSetTraining_Intensity() {
        riskFormModel2.setTraining_Intensity(6);
        assertEquals(6, riskFormModel2.getTraining_Intensity());
    }

    @Test
    public void testGetRecovery_Time() {
        assertEquals(3, riskFormModel2.getRecovery_Time());
    }

    @Test
    public void testSetRecovery_Time() {
        riskFormModel2.setRecovery_Time(7);
        assertEquals(7, riskFormModel2.getRecovery_Time());
    }
}