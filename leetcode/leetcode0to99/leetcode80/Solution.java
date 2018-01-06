package leetcode80;

class Solution {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int j = 0;
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (i == 0 || nums[i] != nums[i - 1] || count < 2) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    count++;
                }
                else {
                    count = 1;
                }
                nums[j++] = nums[i];
            }
        }
        return j;
    }
    public static void main (String[] args) {
        int[] nums = {1,1,1,2,2,3,3,3,3};
        System.out.println(removeDuplicates(nums));
    }
}