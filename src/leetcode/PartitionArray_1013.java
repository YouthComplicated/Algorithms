package leetcode;

public class PartitionArray_1013 {


    public boolean canThreePartsEqualSum(int[] A) {
        int sum  = 0;
        for(int i = 0; i < A.length; i++){
            sum += A[i];
        }
        if(sum % 3 != 0){
            return false;
        }
        int average = sum / 3;
        int averageSum = 0;
        int groupSize = 0;
        for(int i = 0; i < A.length; i++){
            //考虑0特殊性
            if(averageSum == average){
                if(A[i] == 0){
                    averageSum += A[i];
                }else{
                    averageSum = A[i];
                    groupSize ++;
                }
            }else{
                averageSum += A[i];
            }
        }
        return averageSum == average;
    }

    public static void main(String[] args) {
        PartitionArray_1013 instance = new PartitionArray_1013();

//        int [] aa = {0,2,1,-6,6,-7,9,1,2,0,1};
//        System.out.println(instance.canThreePartsEqualSum(aa));
//
//        int [] bb = {0,2,1,-6,6,7,9,-1,2,0,1};
//        System.out.println(instance.canThreePartsEqualSum(bb));
//
//        int [] cc = {3,3,6,5,-2,2,5,1,-9,4};
//        System.out.println(instance.canThreePartsEqualSum(cc));
//
//        int [] dd = {12,-4,16,-5,9,-3,3,8,0};
//        System.out.println(instance.canThreePartsEqualSum(dd));

        int [] ff = {10,-7,13,-14,30,16,-3,-16,-27,27,19};
        System.out.println(instance.canThreePartsEqualSum(ff));
    }
}
