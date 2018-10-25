package jdksource;

public class interfaceDefaultTest {

    public static void main(String[] args) {
        apple a = new apple() {
            @Override
            public int getAppleNum(int i) {
                return 0;
            }
        };
        a.getAppleNum(11);
        a.getColor();
        a.getWeight();


        /**
         * using lamba must have only one abstract method
         */
        apple b = (x)->{
            System.out.println(x);
            return 111;
        };
        b.getAppleNum(333);


    }

    //@FunctionalInterface
    interface apple{
        int getAppleNum(int i);

//        int getShape(String shap);

        default void getColor(){
            System.out.println("red");
        }
        default void getWeight(){
            System.out.println("500g");
        }

//        default int getAppleNum(int i){
//            System.out.println(i);
//            return i;
//        }

//        default int getAppleNum(int i,int b){
//            System.out.println(i);
//            return i;
//        }
    }
}
