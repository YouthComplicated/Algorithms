/**
 * @author NJ
 * @date 2019/1/4 15:50
 */
public class test {

    public static void main(String[] args) {
        for(int i = 0; i< 3; i++){
            if( i == 1){
                if(true){
                    continue;
                }
            }
            System.out.println(i);
        }
    }
}
