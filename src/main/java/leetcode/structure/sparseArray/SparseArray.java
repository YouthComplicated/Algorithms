package leetcode.structure.sparseArray;

import java.io.*;

/**
 * @author: nj
 * @date: 2020-03-23 16:50
 * @version: 0.0.1
 */
public class SparseArray {


    public static void main(String[] args) throws IOException {
        int[][] arr = new int[11][11];

        //assignment
        arr[2][3] = 1;
        arr[0][9] = 1;
        arr[4][7] = 2;
        arr[1][9] = 2;

//        System.out.println(Arrays.toString(arr));
        System.out.println("========原始数组========");
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }


        // common arr convert to sparseArray
        int count = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(arr[i][j] != 0){
                    count ++;
                }
            }
        }

        int[][] sparseArr = new int[count+1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        int k = 1;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(arr[i][j] != 0){
                    sparseArr[k][0] = i;
                    sparseArr[k][1] = j;
                    sparseArr[k][2] = arr[i][j];
                    k++;
                }
            }
        }
        sparseArr[0][2] = count;
        System.out.println("========稀疏数组========");


        for(int i = 0; i < count+1; i++){
            for(int j = 0; j < 3; j++){
                System.out.print(sparseArr[i][j]+"  ");
            }
            System.out.println();
        }

        System.out.println("========数组恢复========");
        int [][] newArr = new int[sparseArr[0][0]][sparseArr[0][1]];

        for(int i = 1; i < sparseArr.length; i++){
            newArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for(int i = 0; i < newArr.length; i++){
            for(int j = 0; j < newArr[0].length; j++){
                System.out.print(newArr[i][j]+"  ");
            }
            System.out.println();
        }

        String path = "/Users/sunzuo/Work/IdeaProjects/Algorithms/src/main/java/leetcode/structure/sparseArray/map.data";
        SparseArray.writeData(sparseArr,path);
        int[][] arrFromFile = SparseArray.readData(sparseArr.length, sparseArr[0].length, path);

        System.out.println("========文件中获取数组========");
        for(int i = 0; i < arrFromFile.length; i++){
            for(int j = 0; j < arrFromFile[0].length; j++){
                System.out.print(arrFromFile[i][j]+"  ");
            }
            System.out.println();
        }

    }


    /**
     * 数据写入
     * @param data
     * @param path
     * @throws IOException
     */
    public static void writeData(int[][] data, String path) throws IOException {
        FileWriter fw = new FileWriter(new File(path));
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[0].length; j++) {
                fw.write(data[i][j] + "\t");
            }
            fw.write("\r\n");
        }
        fw.close();
    }


    public static int[][] readData(int row, int size, String path) throws IOException {
        int[][] res = new int[row][size];
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);
        String line;
        int k = 0;
        while ((line = br.readLine()) != null){
            String[] temp = line.split("\t");
            for (int i = 0; i < temp.length; i++) {
                res[k][i] = Integer.parseInt(temp[i]);
            }
            k ++;
        }
        return res;
    }
}
