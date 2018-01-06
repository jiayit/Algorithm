package leetcode34;

class Solution {
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int lo = 0; 
        int hi = nums.length - 1;
        int mid = 0;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            else if (nums[mid] < target) {
                lo = mid + 1;
            }
            else {
                break;
            }
        }
        if (lo > hi) {
            return result;
        }
        int lo1 = lo;
        int hi1 = mid;
        int lo2 = mid;
        int hi2 = hi;
        while (lo1 <= hi1) {
            int mid1 = (lo1 + hi1) / 2;
            if ((mid1 == 0 && nums[mid1] == target) || (nums[mid1] == target && nums[mid1 - 1] != target)) {
                result[0] = mid1;
                break;
            }
            else if (nums[mid1] < target) {
                lo1 = mid1 + 1;
            }
            else {
                hi1 = mid1 - 1;
            }
        }
        while (lo2 <= hi2) {
            int mid2 = (lo2 + hi2) / 2;
            if ((nums[mid2] == target && mid2 == nums.length - 1) || (nums[mid2] == target && nums[mid2 + 1] != target)) {
                result[1] = mid2;
                break;
            }
            else if (nums[mid2] > target){
                hi2 = mid2 - 1;
            }
            else {
                lo2 = mid2 + 1;
            }
        }
        return result;
    }
    public static void main (String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + "," + result[1]);
    }
}
