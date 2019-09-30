import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

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

    @Test
    public void test01(){
        String str = "clientIp_1";
        int index = str.lastIndexOf("_");
        System.out.println(str.substring(index+1));
    }

    @Test
    public void test02(){
        Map<String, Object> map = new HashMap<>();
        map.put("aa",111);
        System.out.println(map);
    }

    @Test
    public void test03(){
        String OS, ARCH;
        Properties props = System.getProperties();
        OS = String.valueOf(props.get("os.name")).toLowerCase();
        ARCH = String.valueOf(props.get("sun.arch.data.model"));

        System.out.println("OS:"+OS);
        System.out.println("ARCH:"+ARCH);

    }

}
