package headfirst.observertest;

public interface Subject {
    /**
     * 注册观察者
     * @param o
     */
    void registerObserver(Observer o);

    /**
     * 移除观察者
     * @param o
     */
    void removeObserver(Observer o);

    /**
     * 通知观察者
     */
    void notifyObserver();
}
