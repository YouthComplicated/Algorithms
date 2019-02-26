package leetcode;

/**
 * @author NJ
 * @date 2019/2/26 10:47
 */
public class CountAndSay_38 {

    /**
         1.     1
         2.     11
         3.     21
         4.     1211
         5.     111221
         6.     312211
         7.     13112221
         8.     1113213211
         9.     31131211131221
         10.     13211311123113112211

         1 is read off as "one 1" or 11.
         11 is read off as "two 1s" or 21.
         21 is read off as "one 2, then one 1" or 1211.

     */
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 1; i < n; i++){
            char[] array = str.toCharArray();
            int sameNum = 1;
            String result = "";
            for(int j = 0; j < array.length; j++){
                if(j + 1 < array.length){
                    if(array[j] == array[j+1]){
                        sameNum ++ ;
                    }else{
                        result += sameNum + "" +array[j];
                        sameNum = 1;
                    }
                }else{
                    result += sameNum + "" +array[j];
                    sameNum = 1;
                }
            }
            str = result;
        }
        return str;
    }

    public static void main(String[] args) {
        CountAndSay_38 countAndSay_38 = new CountAndSay_38();
        System.out.println(countAndSay_38.countAndSay(8));
    }
}
