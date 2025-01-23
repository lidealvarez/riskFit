package edu.mondragon.riskFit.Model;

public class RealTimeDataRequest {
    private int heartRate;
    private String heartRateTimestamp;

    private int steps;
    private double caloriesBurned;
    private double distance;

    private String sleepStartTime;
    private String sleepEndTime;
    private String sleepQuality;

    // Getters y Setters

    public int getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(int heartRate) {
        this.heartRate = heartRate;
    }

    public String getHeartRateTimestamp() {
        return heartRateTimestamp;
    }

    public void setHeartRateTimestamp(String heartRateTimestamp) {
        this.heartRateTimestamp = heartRateTimestamp;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(double caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getSleepStartTime() {
        return sleepStartTime;
    }

    public void setSleepStartTime(String sleepStartTime) {
        this.sleepStartTime = sleepStartTime;
    }

    public String getSleepEndTime() {
        return sleepEndTime;
    }

    public void setSleepEndTime(String sleepEndTime) {
        this.sleepEndTime = sleepEndTime;
    }

    public String getSleepQuality() {
        return sleepQuality;
    }

    public void setSleepQuality(String sleepQuality) {
        this.sleepQuality = sleepQuality;
    }
}
