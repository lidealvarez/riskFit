package edu.mondragon.riskFit.model;

public class RiskForm {

    private int age;
    private int trainingHoursPerWeek;
    private int trainingIntensity;
    private int weeklyTrainingVolume;
    private double loadProgression;

    public RiskForm(int age, int trainingHoursPerWeek, int trainingIntensity, int weeklyTrainingVolume,
            double loadProgression) {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTrainingHoursPerWeek() {
        return trainingHoursPerWeek;
    }

    public void setTrainingHoursPerWeek(int trainingHoursPerWeek) {
        this.trainingHoursPerWeek = trainingHoursPerWeek;
    }

    public int getTrainingIntensity() {
        return trainingIntensity;
    }

    public void setTrainingIntensity(int trainingIntensity) {
        this.trainingIntensity = trainingIntensity;
    }

    public int getWeeklyTrainingVolume() {
        return weeklyTrainingVolume;
    }

    public void setWeeklyTrainingVolume(int weeklyTrainingVolume) {
        this.weeklyTrainingVolume = weeklyTrainingVolume;
    }

    public double getLoadProgression() {
        return loadProgression;
    }

    public void setLoadProgression(double loadProgression) {
        this.loadProgression = loadProgression;
    }
}
