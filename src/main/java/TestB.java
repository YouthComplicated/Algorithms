import java.util.Arrays;

/**
 * @author: nj
 * @date: 2020-03-01 16:56
 * @version: 0.0.1
 */
public class TestB extends TestA {

    public TestB(String a) {
        super(a);


    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //双指针，不开辟空间情况下，进行移位操作
        int index1 = 0, index2 = 0;
        while (index1 < m+n && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                //发现大于进行插入(移动原始数组))
                int temp = m + index2;
                while (temp >= index1) {
                    nums1[temp] = nums1[temp - 1];
                    temp--;
                }
                nums1[index1] = nums2[index2];
                index1 += 2;
                index2++;
            }
        }
    }

    public static void main(String[] args) {


        TestB a = new TestB("a");
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        a.merge(num1,3,num2,3);
        System.out.println(Arrays.toString(num1));




    }
}