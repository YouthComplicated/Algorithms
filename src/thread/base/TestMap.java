package thread.base;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试对于map进行读写操作
 *
 * 定时任务下(集群模式部署情况下的问题) 全局变量如何保持一致性
 *
 */
public class TestMap {

    private static Map<String, Integer> numMap = new HashMap<>();

    public static void main(String[] args) {
        int groupId1 = 1;
        int groupId2 = 2;
        int groupId3 = 3;
        numMap.put("1_1",11);

        new Thread(()->{
            if(!numMap.containsKey(groupId1+"_1")) {
                numMap.put(groupId1 + "_1", 111);
            }
        }).start();
        new Thread(()->{
            if(!numMap.containsKey(groupId2+"_1")) {
                numMap.put(groupId2 + "_1", 222);
            }
        }).start();
        new Thread(()->{
            if(!numMap.containsKey(groupId3+"_1")) {
                numMap.put(groupId3 + "_1", 333);
            }
        }).start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(numMap.toString());


    }


}
