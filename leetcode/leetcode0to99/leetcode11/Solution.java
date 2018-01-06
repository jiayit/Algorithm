package leetcode11;

class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int max = Math.min(height[0], height[1]);

        int lo = 0; int hi = length - 1;
        while(lo < hi) {
            int area = (hi - lo) * Math.min(height[lo], height[hi]);
            if (area > max) {
                max = area;
            }
            if (height[lo] < height[hi]) {
                lo++;
            }
            else {
                hi--;
            }
        }

        return max;
    }
    public static void main (String[] args) {
        System.out.println();
    }
}