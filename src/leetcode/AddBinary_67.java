package leetcode;


public class AddBinary_67 {

    /**
     *
     * Given two binary strings, return their sum (also a binary string).
     *
     * The input strings are both non-empty and contains only characters 1 or 0.
     *
     * Example 1:
     *
     * Input: a = "11", b = "1"
     * Output: "100"
     * Example 2:
     *
     * Input: a = "1010", b = "1011"
     * Output: "10101"
     */
    public String addBinary(String a, String b) {
        char[] achars = a.toCharArray();
        char[] bchars = b.toCharArray();
        char[] tempArr = new char[Math.max(achars.length, bchars.length) + 1];
        int i = achars.length - 1;
        int j = bchars.length - 1;
        boolean flag = false;
        int temp;
        int k = 0, len = 0;
        for(;;){
            /**
             *  '1' + '1' + '1' = 99  '1'
             *  '1' + '0' + '1' = 98  '0'
             *  '0' + '0' + '1' = 97  '1'
             *  '1' + '1' = 98   '0'
             *  '1' + '0' = 97   '1'
             *  '0' + '0' = 96   '0'
             */

            temp = (i >= 0 ? achars[i] : '0') +
                    (j >= 0 ? bchars[j] : '0');
            if(flag){
                temp += 1;
            }
            if(temp == 99 ){
                flag = true;
                tempArr[k++] = '1';
            }else if(temp == 98){
                flag = true;
                tempArr[k++] = '0';
            }else if(temp == 97){
                flag = false;
                tempArr[k++] = '1';
            }else{
                flag = false;
                tempArr[k++] = '0';
            }
            i--;
            j--;
            len ++;
            if(j < 0 && i < 0){
                break;
            }
        }
        if(flag){
            tempArr[k++] = '1';
        }else{
            len -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int p = len; p >=0; p--){
            sb.append(tempArr[p]);
        }
        return sb.toString();

    }

    /**
     * 改进版
     * @param a
     * @param b
     * @return
     */
    public String addBinary01(String a, String b) {
        char[] tempArr = new char[Math.max(a.length(), b.length()) + 1];
        int i = a.length() - 1;
        int j = b.length()- 1;
        boolean flag = false;
        int temp;
        int k = 0, len = 0;
        for(;;){
            temp = (i >= 0 ? a.charAt(i) : '0') +
                    (j >= 0 ? b.charAt(j) : '0');
            if(flag){
                temp += 1;
            }
            if(temp == 99 ){
                flag = true;
                tempArr[k++] = '1';
            }else if(temp == 98){
                flag = true;
                tempArr[k++] = '0';
            }else if(temp == 97){
                flag = false;
                tempArr[k++] = '1';
            }else{
                flag = false;
                tempArr[k++] = '0';
            }
            i--;
            j--;
            len ++;
            if(j < 0 && i < 0){
                break;
            }
        }
        if(flag){
            tempArr[k++] = '1';
        }else{
            len -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int p = len; p >=0; p--){
            sb.append(tempArr[p]);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
//        String str = "101110";
//        char[] chars = str.toCharArray();
//        System.out.println(Arrays.toString(chars));

//        char a = '0';
//        char b = '0';
//        System.out.println(a+b);
//        System.out.println((int)a+(int)b);

//        String a = "11";
//        String b = "1";

//        String a = "1010";
//        String b = "1011";

        String a = "11";
        String b = "11111";

        AddBinary_67 addBinary_67 = new AddBinary_67();
        System.out.println(addBinary_67.addBinary(a,b));


    }

}
