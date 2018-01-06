package leetcode73;

class Solution {
    // use space O(m + n)
    public static void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] rows = new boolean[row];
        boolean[] cols = new boolean[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (rows[i]) {
                    matrix[i][j] = 0;
                }
                if (cols[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
    // in space
    public static void setZeroes1(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int col0 = 1;
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
    public static void main (String[] args) {
        int[][] matrix = {{1,1,1},{0,1,2}};
        setZeroes1(matrix);
        for (int[] row : matrix) {
            for (int x : row) {
                System.out.print(x);
            }
            System.out.println();
        }

    }
}