package leetcode53;

import java.util.Arrays;

class Solution {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        int sum = 0;
        int max = 0;
        for (int low = 0; low < n; low++) {
            if (nums[low] > 0) {
                sum = sum + nums[low];
                if (sum > max) {
                    max = sum;
                }
            }
            else if (nums[low] + sum > 0 ) {
                sum = sum + nums[low];
                if (sum > max) {
                    max = sum;
                }
            }
            else {
                sum = 0;
            }
        }
        Arrays.sort(nums);
        if (nums[n - 1] < 0) {
            max = nums[n - 1];
        }
        return max;
    }
    // DP
    public int maxSubArray1(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }

        return max;
    }
    public static void main (String[] args) {
        int[] nums = {1,2,-1,-2,2,1,-2,1,4,-5,4};
        int[] nums1 = {-2,-1};
        System.out.println(maxSubArray(nums));
    }
}
