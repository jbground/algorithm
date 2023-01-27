package org.jsjeong.design.observer;

public class ForecastDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humidity;

    public ForecastDisplay(WeatherData weatherData) {
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {

    }


}
