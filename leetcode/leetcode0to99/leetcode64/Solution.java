package leetcode64;

class Solution {
    public static int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] minSum = new int[row][col];
        minSum[0][0] = grid[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j > 0) {
                    minSum[i][j] = minSum[i][j - 1] + grid[i][j];
                }
                else if (j == 0 && i > 0) {
                    minSum[i][j] = minSum[i - 1][j] + grid[i][j];
                }
                else if (i > 0 && j > 0) {
                    minSum[i][j] = Math.min(minSum[i - 1][j], minSum[i][j - 1]) + grid[i][j];
                }
            }
        }
        return minSum[row - 1][col - 1];
    }
    public static void main (String[] args) {
        int[][] grid = {{1,3,1}, {1,5,1}, {4,2,1}};
        int[][] grid1 = {{1,3,1}};
        System.out.println(minPathSum(grid1));
    }
}