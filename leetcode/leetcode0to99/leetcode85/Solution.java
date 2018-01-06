package leetcode85;

public class Solution {

    public static int maximalRectangle(int[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right= new int[n];
        int[]  height= new int[n];

        for (int i = 0; i < n; i++) {
            right[i] = n;
        }
        boolean[] flag = new boolean[n];
        int maxA = 0;
        for(int i=0; i<m; i++) { 
            int cur_left=0, cur_right=n; 

            for(int j=0; j<n; j++) { // compute height (can do this from either side)

                if(matrix[i][j]== 1) {
                    int count = 2 * height[j] - 1;
                    int mid = (right[j] - 1+ left[j]) / 2;
                    if (height[j] == 0) {
                        flag[j] = true;
                    }
                    else if (right[j]-left[j] == count && flag[mid]) {
                        flag[mid] = true;
                    }
                    else {
                        flag[mid] = false;
                    }
                    height[j]++;  
                }
                else height[j]=0;
            }
            for(int j=0; j<n; j++) { // compute left (from left to right)
                if(matrix[i][j]== 1) left[j]= Math.max(left[j],cur_left);
                else {left[j]=0; cur_left=j+1;}
            }
            // compute right (from right to left)
            for(int j=n-1; j>=0; j--) {
                if(matrix[i][j]== 1) right[j]= Math.min(right[j],cur_right);
                else {right[j]=n; cur_right=j;}    
            }
            // compute the area of rectangle (can do this from either side)
            for(int j=0; j<n; j++) {
                int mid = (right[j] - 1+ left[j]) / 2;
                int count = 2 * height[mid] - 1;
                if (right[j]-left[j] == count && flag[mid]) {
                    maxA = Math.max(maxA,height[mid]);
                }
            }

        }
        return maxA;
    }
    public static void main(String[] args) {
        int[][] x = {{0,0,1,0,0},{1,1,1,1,1},{1,1,1,1,1}};
        System.out.println(maximalRectangle(x));
    }
}
