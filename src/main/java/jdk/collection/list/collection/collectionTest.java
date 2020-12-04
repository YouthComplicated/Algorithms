package jdk.collection.list.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author: nj
 * @date: 2020-08-24 10:35
 * @version: 0.0.1
 */
public class collectionTest {

    public static void main(String[] args) {


        List<String> list = Collections.emptyList();
//        list.add("aa");
        System.out.println(list.toString());
        list = new ArrayList<>();
        list.add("bb");
        System.out.println(list);


    }
}