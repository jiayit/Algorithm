package leetcode63;

class Solution {
    // dp single array
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
            }
        }
        return dp[width - 1];
    }
    // dp two-dimentional array
    public static int uniquePathsWithObstacles1 (int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
                else if (i == 0 && j > 0){
                    dp[i][j] = dp[i][j - 1];
                }
                else if (j == 0 && i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }
                else if (i > 0 && j > 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[row - 1][col - 1];
    }
    public static void main (String[] args) {
        int[][] matrix = {{0,0,0,0}, {0,0,1,0},{0,0,0,0}, {0,0,0,0}};
        int[][] matrix1 = {{1,0}};
        System.out.println(uniquePathsWithObstacles1(matrix1));
    }
}
