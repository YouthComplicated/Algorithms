package headfirst.observertest;

public interface Observer {
    /**
     * 更新温度
     * @param temp
     * @param hum
     * @param pressure
     */
    void update(float temp, float hum, float pressure);

}
