package headfirst.observertest;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

    private List<Observer> observers;

    private float temperature;
    private float hum;
    private float pressure;



    public WeatherData() {
        this.observers = new ArrayList<>();
    }


    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(o);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(x->{
            x.update(temperature,hum,pressure);
        });
    }

    public void measureChanaged(){
        notifyObserver();
    }

    public void setMeasure(float temperature, float hum, float pressure){
        this.temperature = temperature;
        this.hum = hum;
        this.pressure = pressure;
        measureChanaged();
    }

}
