package org.jsjeong.design.observer;

public class WeatherStation {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
        StaticsDisplay staticsDisplay = new StaticsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80, 22, 30.4f);
        weatherData.setMeasurements(90, 65, 60.4f);
        weatherData.setMeasurements(88, 80, 70.4f);


    }
}
