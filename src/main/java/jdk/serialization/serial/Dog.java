package jdk.serialization.serial;

import java.io.*;

public class Dog implements Serializable {

//    transient public String aa;

    transient private String name;

    transient private int age;

    transient private int sex;


    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeInt(age);
        outputStream.writeInt(sex);
        outputStream.writeUTF(name);

    }

    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        sex = inputStream.readInt();
        age = inputStream.readInt();
        name = inputStream.readUTF();
    }

    private Object readResolve() throws ObjectStreamException {
        return null;
    }

    public Dog(String name, int age, int sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dog(int age, int sex) {
        this.age = age;
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
