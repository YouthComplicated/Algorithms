package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: nj
 * @date: 2020-04-25 15:50
 * @version: 0.0.1
 */
public class Code_811 {


    /**
     *
     *
     * 字符串的API
     *
     *
     * @param cpdomains
     * @return
     */
    public static List<String> subdomainVisits(String[] cpdomains) {

        List<String> result = new ArrayList<>();
        Map<String, Integer> timeMap = new HashMap<>();
        int number, index, spaceIndex;
        for (String str : cpdomains){
            spaceIndex = str.indexOf(" ");
            number = Integer.parseInt(str.substring(0, spaceIndex));
            str = str.substring(spaceIndex + 1);
            timeMap.put(str, timeMap.getOrDefault(str, 0) + number);
            while (true){
                index = str.indexOf(".");
                if(index == -1){
                    break;
                }
                String temp = str.substring(index + 1);
                timeMap.put(temp, timeMap.getOrDefault(temp, 0) + number);
                str = temp;
            }

        }
        for(Map.Entry<String, Integer> entry : timeMap.entrySet()){
            result.add(entry.getValue()+" "+ entry.getKey());
        }
        return result;
    }


    public List<String> subdomainVisits1(String[] cpdomains) {
        Map<String, Integer> counts = new HashMap();
        for (String domain: cpdomains) {
            String[] cpinfo = domain.split("\\s+");
            String[] frags = cpinfo[1].split("\\.");
            int count = Integer.valueOf(cpinfo[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; --i) {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                counts.put(cur, counts.getOrDefault(cur, 0) + count);
            }
        }

        List<String> ans = new ArrayList();
        for (String dom: counts.keySet())
            ans.add("" + counts.get(dom) + " " + dom);
        return ans;
    }

    public static void main(String[] args) {
        String [] str1 = {"9001 discuss.leetcode.com"};
//        System.out.println(subdomainVisits(str1).toString());


        String [] str2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(str2));


    }

}