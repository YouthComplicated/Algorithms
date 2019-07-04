package jdk.reflect;

import java.util.ArrayList;
import java.util.List;

public class GenericsClass {


    private List<String> stringList;

    private List<Integer> integerList;

    public List<String> getStringList() {
        return stringList;
    }

    private List<Teacher> getTeachers(Teacher teacher){
        return new ArrayList<>();
    }

    private void getIds(List<Integer> ids){
        System.out.println(ids);
    }


    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public List<Integer> getIntegerList() {
        return integerList;
    }

    public void setIntegerList(List<Integer> integerList) {
        this.integerList = integerList;
    }

    @Override
    public String toString() {
        return "GenericsClass{" +
                "stringList=" + stringList +
                ", integerList=" + integerList +
                '}';
    }
}
