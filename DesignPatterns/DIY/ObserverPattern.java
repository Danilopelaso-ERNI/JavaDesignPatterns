package DesignPatterns.DIY;

import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update();
}

class WeatherStation {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;
    private float humidity;
    private float pressure;

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    public float getTemperature() {
        return temperature;
    }

    public float getHumidity() {
        return humidity;
    }

    public float getPressure() {
        return pressure;
    }

    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class CurrentConditionsDisplay implements Observer {
    private WeatherStation weatherStation;

    public CurrentConditionsDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("Current conditions: " + weatherStation.getTemperature() + "°C, " +
                weatherStation.getHumidity() + "% humidity, " +
                weatherStation.getPressure() + " hPa pressure.");
    }
}

class StatisticsDisplay implements Observer {
    private WeatherStation weatherStation;

    public StatisticsDisplay(WeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public void update() {
        System.out.println("Statistics: " + weatherStation.getTemperature() + "°C, " +
                weatherStation.getHumidity() + "% humidity, " +
                weatherStation.getPressure() + " hPa pressure.");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherStation);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherStation);

        weatherStation.addObserver(currentDisplay);
        weatherStation.addObserver(statisticsDisplay);

              weatherStation.setMeasurements(25.0f, 65.0f, 1013.0f);  
        weatherStation.setMeasurements(22.0f, 70.0f, 1012.0f);  
    }
}