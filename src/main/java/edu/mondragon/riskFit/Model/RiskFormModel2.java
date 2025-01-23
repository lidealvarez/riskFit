package edu.mondragon.riskFit.Model;
public class RiskFormModel2 {
    private int player_Age;
    private double player_Weight;
    private double player_Height;
    private int previous_Injuries;
    private int training_Intensity;
    private int recovery_Time;

    public RiskFormModel2(int player_Age, double player_Weight, double player_Height, int previous_Injuries,
            int training_Intensity, int recovery_Time) {
    }

    // Getters y Setters
    public int getPlayer_Age() {
        return player_Age;
    }

    public void setPlayer_Age(int player_Age) {
        this.player_Age = player_Age;
    }

    public double getPlayer_Weight() {
        return player_Weight;
    }

    public void setPlayer_Weight(double player_Weight) {
        this.player_Weight = player_Weight;
    }

    public double getPlayer_Height() {
        return player_Height;
    }

    public void setPlayer_Height(double player_Height) {
        this.player_Height = player_Height;
    }

    public int getPrevious_Injuries() {
        return previous_Injuries;
    }

    public void setPrevious_Injuries(int previous_Injuries) {
        this.previous_Injuries = previous_Injuries;
    }

    public int getTraining_Intensity() {
        return training_Intensity;
    }

    public void setTraining_Intensity(int training_Intensity) {
        this.training_Intensity = training_Intensity;
    }

    public int getRecovery_Time() {
        return recovery_Time;
    }

    public void setRecovery_Time(int recovery_Time) {
        this.recovery_Time = recovery_Time;
    }
}
