package leetcode54;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) {
            return list;
        }
        int size = matrix.length * matrix[0].length;
        if (size == 1) {
            list.add(matrix[0][0]);
            return list;
        }
        int rowUp = 0;
        int rowDown = matrix.length - 1;
        int colLeft = 0;
        int colRight = matrix[0].length - 1;
        int n = 0;
        int m = 0;
        while (list.size() != size) {
            while (m < colRight && n == rowUp ) {
                if (!list.contains(matrix[n][m])) {
                    list.add(matrix[n][m]);
                }
                m++;

            }
            while (n < rowDown && m == colRight) {
                if (!list.contains(matrix[n][m])) {
                    list.add(matrix[n][m]);
                }
                n++ ;

            }
            while (n == rowDown && m > colLeft) {
                if (!list.contains(matrix[n][m])) {
                    list.add(matrix[n][m]);
                }
                m--;
            }
            while (m == colLeft && n > rowUp) {
                if (!list.contains(matrix[n][m])) {
                    list.add(matrix[n][m]);
                }
                n--;

            }
            rowUp++;
            colRight--;
            rowDown--;
            colLeft++;
            m = colLeft;
            n = rowUp;
            if (colLeft == colRight && rowDown == rowUp) {
                list.add(matrix[rowUp][colLeft]);
            }

        }
        return list;
    }
    public static void main (String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix1 = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] matrix2 = {{1,2,3,4,5,6,7,8,9,10},{11,12,13,14,15,16,17,18,19,20}};
        int[][] matrix3 = {{6,9,7}};
        for (int x : spiralOrder(matrix1)) {
            System.out.print(x);
            System.out.print(",");
        }
    }
}