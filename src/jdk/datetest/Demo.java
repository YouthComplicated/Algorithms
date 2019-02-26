package jdk.datetest;

import org.junit.Test;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author NJ
 * @date 2019/2/16 14:36
 */
public class Demo {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> list = (List<Integer>) map.get("aa");
        System.out.println((List<Integer>)null);

        Map<String, Object> paramMap = null;
        System.out.println(paramMap.get("bbb"));
    }

    @Test
    public void testTimeStamp(){

        Timestamp time = new Timestamp(System.currentTimeMillis());
        System.out.println(time);

    }

}
