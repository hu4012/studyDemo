package com.offer;

/**
 * describe:
 *
 * @author hu
 * @date 2021/07/22
 * @time 23:01
 */

public class Struct2Search {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(find(matrix, 4, 4, 6));
    }

    static boolean find(int[][] matrix, int rows, int cols, int number) {
        boolean found = false;
        if (matrix != null && rows > 0 && cols > 0) {
            int row = 0;
            int col = cols - 1;
            while (row < rows && col >=0) {
                if (matrix[row][col] == number) {
                    found = true;
                    System.out.printf("Found! at col:%s row:%s %n", col+1, row+1);
                    break;
                } else if (matrix[row][col] > number) {
                    --col;
                } else {
                    ++row;
                }
            }
        }
        return found;
    }
}
