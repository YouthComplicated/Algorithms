

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 常用的简单优化场景
 * 1、jvm内存模型
 * 2、jdk集合正规使用
 * 3、逻辑的处理
 */
public class Optimization {
    /**
     * 集合遍历方式的比较
     * 1、for
     * 2、迭代器
     * 3、数组下标
     * 4、jdk1.8 stream
     */
    @Test
    public void test01(){
        String str1;
        List<String> list = new ArrayList<>();
        for(String str : list ){
            System.out.println(str);
        }
    }

    @Test
    public void test02(){

    }





}
