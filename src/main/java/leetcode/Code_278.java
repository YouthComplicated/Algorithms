package leetcode;

/**
 * @author: nj
 * @date: 2020-03-22 11:35
 * @version: 0.0.1
 */
public class Code_278 {

    /**
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version
     * of your product fails the quality check. Since each version is developed based on the previous version, all the versions
     * after a bad version are also bad.
     *
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     *
     * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first
     * bad version. You should minimize the number of calls to the API.
     *
     * Example:
     *
     * Given n = 5, and version = 4 is the first bad version.
     *
     * call isBadVersion(3) -> false
     * call isBadVersion(5) -> true
     * call isBadVersion(4) -> true
     *
     * Then 4 is the first bad version.
     */


    /**
     *
     * 二分法查找, start+end 会导致超出精度
     *
     */
    public static int firstBadVersion(int n) {
        int start = 0, end = n;
        int middle;
        while(end - start > 1){
            if(start % 2 != 0 && end % 2 != 0 ){
                middle = start / 2  + end / 2 + 1;
            }else{
                middle = start / 2  + end / 2;
            }
            if(!isBadVersion(middle)){
                start = middle;
            }else{
                end = middle;
            }
        }
        return end;
    }

    public int firstBadVersion11(int n) {
        int l = 1;
        int r = n;
        while (l<r ){
            int mid = l+(r-l)/2;
            if (isBadVersion(mid))
                r = mid;
            else
                l = mid+1;
        }
        return l;
    }


    public static void main(String[] args) {
        System.out.println(firstBadVersion(2126753390));


    }


    /**
     * 2126753390
     * 1702766719
     * @param version
     * @return
     */
    static boolean isBadVersion(int version){
        if(version < 1702766719){
            return false;
        }
        return true;
    }


}