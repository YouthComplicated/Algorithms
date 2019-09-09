package leetcode;

public class BitCharacters_717 {


    /**
     *We have two special characters. The first character can be represented by one bit 0.
     * The second character can be represented by two bits (10 or 11).
     *
     * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not.
     * The given string will always end with a zero.
     *
     * Example 1:
     * Input:
     * bits = [1, 0, 0]
     * Output: True
     * Explanation:
     * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
     * Example 2:
     * Input:
     * bits = [1, 1, 1, 0]
     * Output: False
     * Explanation:
     * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
     * Note:
     *
     * 1 <= len(bits) <= 1000.
     * bits[i] is always 0 or 1.
     */

    public static boolean  isOneBitCharacter(int[] bits) {
        int len = bits.length;
        for(int i = 0; i < len; i++){
            if(bits[i] == 1){
                if( i + 1 == len - 1 || i == len - 1 ){
                    return false;
                }else{
                    i++;
                }
            }

        }
        return bits[len - 1] == 0 ? true : false;
    }


    public static boolean isOneBitCharacter1(int[] bits) {
        int i = 0;
        while(i < bits.length - 1){
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }






    public static void main(String[] args) {

        int [] arr1 = {0};
        int [] arr2 = {1,1,1,0};
        int [] arr3 = {1,0,0};
        int [] arr4 = {1,0,1,0,0};
        System.out.println(BitCharacters_717.isOneBitCharacter(arr1));
        System.out.println(BitCharacters_717.isOneBitCharacter(arr2));
        System.out.println(BitCharacters_717.isOneBitCharacter(arr3));
        System.out.println(BitCharacters_717.isOneBitCharacter(arr4));


    }





}
