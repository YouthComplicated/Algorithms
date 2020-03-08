/**
 * @author: nj
 * @date: 2020-02-29 20:30
 * @version: 0.0.1
 */
public class test01 {


    public static void swap(int a , int b){
        int tmp = a;
        a = b;
        b = tmp;
        System.out.println("swap方法里，a的值是"
                + a + "；b的值是" + b);
    }

    public static void swap(DataSwap ds){
        int tmp = ds.a;
        ds.a = ds.b;
        ds.b = tmp;
        System.out.println("swap方法里，a Field的值是"
                + ds.a + "；b Field的值是" + ds.b);
    }

    //返回两个整数的和
    int add(int x,int y){return x+y;}
//    short add(int x,int y){return (short)(x+y);}
    //返回三个整数的和
    int add(int x,int y,int z){return x+y+z;}
    //返回两个小数的和
    double add(double x,double y){return x+y;}

    public static void main(String[] args) {
        int a = 6;
        int b = 9;
        swap(a , b);
        System.out.println("交换结束后，变量a的值是"
                + a + "；变量b的值是" + b);


        DataSwap ds = new DataSwap();
        ds.a = 6;
        ds.b = 9;
        swap(ds);
        System.out.println("交换结束后，a Field的值是"
                + ds.a + "；b Field的值是" + ds.b);

    }
}
class DataSwap{
    public int a;
    public int b;
}
