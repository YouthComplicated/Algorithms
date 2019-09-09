package leetcode;

public class DefangingIPAddress_1108 {

    /**
     * Given a valid (IPv4) IP address, return a defanged version of that IP address.
     *
     * A defanged IP address replaces every period "." with "[.]".
     *
     *
     *
     * Example 1:
     *
     * Input: address = "1.1.1.1"
     * Output: "1[.]1[.]1[.]1"
     * Example 2:
     *
     * Input: address = "255.100.50.0"
     * Output: "255[.]100[.]50[.]0"
     */


    public static String defangIPaddr(String address) {
        String [] arr = address.split("\\.");
        StringBuilder sb = new StringBuilder(arr[0]);
        for(int i = 0; i < 3; i ++){
            sb.append("[.]").append(arr[i+1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("1.1.1.1"));
        System.out.println(defangIPaddr("255.100.50.0"));

    }
}
