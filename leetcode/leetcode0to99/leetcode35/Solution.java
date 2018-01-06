package leetcode35;

class Solution {
    public static int searchInsert(int[] nums, int target) {
        int length = nums.length;
        int lo = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] == target) {
                return i;
            }
            if (nums[lo] < target) {
                lo++;
            }
        }
        return lo;
    }
    public static int searchInsert1 (int[] nums, int target) {
        int low = 0; int high = nums.length -1;
        while (low <= high) {
            int min = (low + high) / 2;
            if (target == nums[min]) {
                return min;
            }
            if (target > nums[min]) {
                low = min + 1;
            }
            if (target < nums[min]) {
                high = min - 1;
            }
        }
        return low;
    }
    public static void main (String[] args) {
        int[] nums = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert1(nums, target));
    }
}