package leetcode74;

class Solution {
    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0 ) {
            return false;
        }
        int col = matrix[0].length;
        if (col == 0 ) {
            return false;
        }
        int lo = 0;
        int hi = col - 1;
        for (int i = 0; i < row; i++) {
            if (target <= matrix[i][col - 1] && target >= matrix[i][0]) {
                while (lo <= hi) {
                    int mid = (lo + hi) / 2;
                    if (matrix[i][mid] == target) {
                        return true;
                    }
                    else if (matrix[i][mid] > target) {
                        hi = mid - 1;
                    }
                    else {
                        lo = mid + 1;
                    }
                }
            }
        }
        return false;
    }

    public static void main (String[] args) {
        int[][] matrix = {{1,3,4,7},{10,11,16,20},{23,30,34,50}};
        int target = 50;
        System.out.println(searchMatrix(matrix, target));
    }
}