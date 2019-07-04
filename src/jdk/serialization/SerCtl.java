package jdk.serialization;

import java.io.*;


public class SerCtl implements Serializable {

    public SerCtl(String a, String b) {
        this.a = a;
        this.b = b;
    }

    String a;

    transient String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "SerCtl{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                '}';
    }


    private void writeObject(ObjectOutputStream outputStream)throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(b);
    }
    private void readObject(ObjectInputStream inputStream)throws IOException, ClassNotFoundException{
        inputStream.defaultReadObject();
        b=(String)inputStream.readObject();
    }

    public static void main(String[] args) {
        SerCtl sc = new SerCtl("aaa","bbb");
        System.out.println("Before:\n"+sc);
        ByteArrayOutputStream buf = new ByteArrayOutputStream();
        try{
            ObjectOutputStream out1 = new
                    ObjectOutputStream(buf);

            out1.writeObject(sc);

            ObjectInputStream in1 = new
                    ObjectInputStream(new
                    ByteArrayInputStream(buf.toByteArray()));

            SerCtl sc2 = (SerCtl)in1.readObject();
            System.out.println("After:\n"+sc2);

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }



}
