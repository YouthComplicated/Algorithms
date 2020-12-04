package model;

/**
 *
 *
 * @author: nj
 * @date: 2020-08-12 14:14
 * @version: 0.0.1
 */
public enum TestEnum {


    IS_RAIN(true), STOP_RAIN(false);

    private boolean isRain;

    TestEnum(boolean isRain) {
        this.isRain = isRain;
    }

    public boolean isRain(){
        return this.isRain;
    }
}