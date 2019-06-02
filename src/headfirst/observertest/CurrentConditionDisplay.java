package headfirst.observertest;

public class CurrentConditionDisplay implements  DisplayElement, Observer {

    /**
     * 温度
     */
    private float temperature;
    /**
     * 湿度
     */
    private float hum;

    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionDisplay:[temperature]" + temperature+",[hum]" +hum);
    }

    @Override
    public void update(float temp, float hum, float pressure) {
        this.temperature = temp;
        this.hum = hum;
        display();
    }
}
