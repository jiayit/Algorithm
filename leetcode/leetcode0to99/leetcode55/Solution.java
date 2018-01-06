package leetcode55;

class Solution {
    public static boolean canJump(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return true;
        }
        int len = 1;
        for (int i = length - 2; i >= 0; i--) {
            if (nums[i] >= len) {
                len = 1;
            }
            else {
                len++;
            }
        }
        if (nums[0] >= len) {
            return true;
        }

        return false;
    }
    public static void main (String[] args) {
        int[] nums = {2,1,0,1,3};
        System.out.println(canJump(nums));
    }
}