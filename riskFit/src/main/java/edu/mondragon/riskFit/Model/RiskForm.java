package edu.mondragon.riskFit.Model;

public class RiskForm {
    private double age; // Edad
    private double trainingHoursPerWeek; // Horas de entrenamiento por semana
    private double trainingIntensity; // Intensidad del entrenamiento
    private double weeklyTrainingVolume; // Volumen de entrenamiento semanal
    private double loadProgression; // Progresión de carga

    // Getters y setters para cada atributo
    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public double getTrainingHoursPerWeek() {
        return trainingHoursPerWeek;
    }

    public void setTrainingHoursPerWeek(double trainingHoursPerWeek) {
        this.trainingHoursPerWeek = trainingHoursPerWeek;
    }

    public double getTrainingIntensity() {
        return trainingIntensity;
    }

    public void setTrainingIntensity(double trainingIntensity) {
        this.trainingIntensity = trainingIntensity;
    }

    public double getWeeklyTrainingVolume() {
        return weeklyTrainingVolume;
    }

    public void setWeeklyTrainingVolume(double weeklyTrainingVolume) {
        this.weeklyTrainingVolume = weeklyTrainingVolume;
    }

    public double getLoadProgression() {
        return loadProgression;
    }

    public void setLoadProgression(double loadProgression) {
        this.loadProgression = loadProgression;
    }
}
