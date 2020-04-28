package leetcode;

/**
 * @author: nj
 * @date: 2020-04-25 16:56
 * @version: 0.0.1
 */
public class Code_812 {


    public double largestTriangleArea(int[][] points) {
        int xMin = 51, yMin = 51, xMax = -51, yMax = -51;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[0].length; j++) {
//                if(){
//
//                }
            }

        }

        return 0.0;
    }

    public double largestTriangleArea1(int[][] p) {
        double res = 0;
        for (int[] i: p)
            for (int[] j: p)
                for (int[] k: p)
                    res = Math.max(res, 0.5 * Math.abs(i[0] * j[1] + j[0] * k[1] + k[0] * i[1]- j[0] * i[1] - k[0] * j[1] - i[0] * k[1]));
        return res;
    }

}