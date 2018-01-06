package leetcode59;

class Solution {
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if (n == 1) {
            matrix[0][0] = 1;
            return matrix;
        }
        int rowUp = 0;
        int rowDown = n - 1;
        int colLeft = 0;
        int colRight = n - 1;
        int row = rowUp;
        int col = colLeft;
        for (int i = 1; i <= n * n;) {
            while (row == rowUp && col < colRight) {
                matrix[row][col++] = i++;

            }
            while (col == colRight && row < rowDown) {
                matrix[row++][col] = i++;
            }
            while (row == rowDown && col > colLeft) {
                matrix[row][col--] = i++;
            }
            while (col == colLeft && row > rowUp) {
                matrix[row--][col] = i++;
            }
            rowUp++;
            colRight--;
            rowDown--;
            colLeft++;
            row = rowUp;
            col = colLeft;
            if (rowDown == rowUp && colLeft == colRight) {
                matrix[row][col] = i++;
            }
        }
        return matrix;
    }
    public static void main (String[] args) {
        int n = 1;
        int[][] matrix = generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }
}