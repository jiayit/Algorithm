package leetcode81;

class Solution {
    public static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (target == nums[mid]) {
                return true;
            }
            else if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                }
                else {
                    lo = mid + 1;
                }
            }
            else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                }
                else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
    public static boolean search1 (int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        int lo1 = 0; 
        int hi1 = 0;
        int lo2 = 1;
        int hi2 = n - 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[lo2] && nums[i] != nums[i - 1]) {
                lo2 = i;
            }
        }
        hi1 = lo2 - 1;
        while (lo1 <= hi1) {
            int mid = (lo1 + hi1) / 2;
            if (target == nums[mid]) {
                return true;
            }
            else if (target > nums[mid]) {
                lo1 = mid + 1;
            }
            else {
                hi1 = mid - 1;
            }
        }
        while (lo2 <= hi2) {
            int mid = (lo2 + hi2) / 2;
            if (target == nums[mid]) {
                return true;
            }
            else if (target > nums[mid]) {
                lo2 = mid + 1;
            }
            else {
                hi2 = mid - 1;
            }
        }
        return false;
    }
    public static void main (String[] args) {
        int[] nums = {};
        int target = 5;
        System.out.println(search1(nums, target));
    }
}
