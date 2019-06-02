package headfirst.observertest;

public class StaticsConditionDisplay implements DisplayElement, Observer{

    private Subject WeatherData;

    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float hum;
    /**
     * 压力
     */
    private float pressure;

    public StaticsConditionDisplay(Subject weatherData) {
        WeatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("StaticsConditionDisplay:[temperature]" + temperature+",[hum]" +hum);
    }

    @Override
    public void update(float temp, float hum, float pressure) {
        this.temperature = temp;
        this.hum = hum;
        this.pressure = pressure;

    }
}
