package leetcode16;

import java.util.Arrays;

class Solution {
    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        int sum = nums[0] + nums[1] + nums[2];
        int min = Math.abs(nums[0] + nums[1] + nums[2] - target);
        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo = i + 1; int hi = length - 1;
                while (lo < hi) {
                    if (Math.abs(nums[i] + nums[lo] + nums[hi] - target) < min) {
                        min = Math.abs(nums[i] + nums[lo] + nums[hi] - target);
                        sum = nums[i] + nums[lo] + nums[hi];
                    }
                    if (nums[i] + nums[lo] + nums[hi] - target < 0){
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }
        return sum;
    }
    public static void main (String[] args) {
        int[] nums = {0,2,1,-3};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}