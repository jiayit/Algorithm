package leetcode62;

class Solution {
    public static int uniquePaths(int m, int n) {
        int path = 0;
        long factorialM = 1;
        long factorialN = 1;
        int col = Math.max(m, n);
        int row = Math.min(m, n);
        for (int i = 1; i < row; i++) {
            factorialM = factorialM * i;
        }

        for (int i = col; i < row + col - 1; i++) {
            factorialN = factorialN * i;

        }

        path  = (int) (factorialN / factorialM);
        return path;
    }
    public static void main (String[] args) {
        System.out.println(uniquePaths(10, 10));
    }
}