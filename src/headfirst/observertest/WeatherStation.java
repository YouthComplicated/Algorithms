package headfirst.observertest;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay display = new CurrentConditionDisplay(weatherData);

        weatherData.setMeasure(1,2,3);
        weatherData.setMeasure(3,4,5);
        weatherData.setMeasure(6,7,8);

//        display.display();



    }
}
