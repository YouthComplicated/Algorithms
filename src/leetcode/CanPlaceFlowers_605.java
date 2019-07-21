package leetcode;

public class CanPlaceFlowers_605 {

    /**
     * Suppose you have a long flowerbed in which some of the plots are planted and some are not.
     * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
     *
     * Given a flowerbed (represented as an array containing 0 and 1,
     * where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
     *
     * Example 1:
     * Input: flowerbed = [1,0,0,0,1], n = 1
     * Output: True
     * Example 2:
     * Input: flowerbed = [1,0,0,0,1], n = 2
     * Output: False
     * Note:
     * The input array won't violate no-adjacent-flowers rule.
     * The input array size is in the range of [1, 20000].
     * n is a non-negative integer which won't exceed the input array size.
     *
     */


    /**
     *
     * 1、 001   100
     *
     * 2、10001
     *
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int zeroNum = 0,result = 0;
        if(flowerbed[0] == 0){
            zeroNum ++;
        }
        for(int i = 0; i < flowerbed.length; i++){
            if(flowerbed[i] == 0){
                if(i == flowerbed.length - 1){
                    zeroNum += 2;
                    result += (zeroNum - 1) / 2;
                }else{
                    zeroNum ++;
                }
            }else{
                result += (zeroNum - 1) / 2;
                zeroNum = 0;
            }
        }
        System.out.println(result);
        return result >= n;

    }

    public boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        for (int i = 0; i< flowerbed.length; i++) {
            if (flowerbed[i] == 0) {
                int next = i == flowerbed.length - 1 ? 0 : flowerbed[i+1];
                int prev = i == 0 ? 0 : flowerbed[i-1];

                if (next == 0 && prev == 0) {
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    public static void main(String[] args) {
//        int [] arr1 = {1,0,0,0,1};
//        System.out.println(canPlaceFlowers(arr1,1));
//        System.out.println(canPlaceFlowers(arr1,2));

//        int [] arr2 = {0,0,1,0,0,0,1,0,0};
//        System.out.println(canPlaceFlowers(arr2,1));

        int [] arr3= {0,1,0,0,0,1,1,0,0};
        System.out.println(canPlaceFlowers(arr3,2));

    }

}
