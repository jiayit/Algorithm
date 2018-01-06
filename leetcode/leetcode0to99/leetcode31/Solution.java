package leetcode31;

import java.util.Arrays;

class Solution {
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = length - 1;
        while (index > 0) {
            if (nums[index] > nums[index - 1]) {
                break;
            }
            index--;
        }
        if (index == 0) {
            Arrays.sort(nums);
            return;
        }

        int minMax = index;
        for (int j = index + 1; j < length; j++) {
            if (nums[j] < nums[minMax] && nums[j] > nums[index- 1] ) {
                minMax = j;
            }

        }
        swap(index - 1, minMax, nums);
        Arrays.sort(nums, index, length);

    }
    public static void swap (int index1, int index2, int[] nums) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
    public static void main (String[] args) {
        int[] nums = {4,3,2,1};
        int[] nums1 = {2,2,3,4,2,3,1,1,2};
        nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num);
        }
    }
}