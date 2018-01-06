package leetcode48;

class Solution {
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int m = (n % 2) == 0 ? 2 : 3; m <= n; m += 2) {
            int row = (n - m) / 2;
            int[] temp = new int[m];;
            for (int j = 0; j < m - 1; j++) {
                temp[j] = matrix[row][row + j];
                matrix[row][row + j] = matrix[row + m - (j + 1)][row];
                matrix[row + m - (j + 1)][row] = matrix[row + m - 1][row + m - (j + 1)];
                matrix[row + m - 1][row + m - (j + 1)] = matrix[row + j][row + m - 1];
                matrix[row + j][row + m - 1] = temp[j];

            }


        }
    }
    public static void main (String[] args) {
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}