package jdk.collection.map;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author NJ
 * @date 2019/3/5 11:39
 */
public class TestMap {


    @Test
    public void testMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);

        System.out.println(map);

        System.out.println(map.getOrDefault("a", 45));

    }


}
