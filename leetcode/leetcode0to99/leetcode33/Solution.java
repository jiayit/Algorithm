package leetcode33;

class Solution {
    public static int search(int[] nums, int target) {
        int low1 = 0, high1 = nums.length - 1, low2 = 0, high2 = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < nums[low2]) {
                low2 = i;
            }
        }
        if (low2 > 0) {
            high1 = low2 - 1;
        }
        while (low1 <= high1 && low2 <= high2) {
            if (target < nums[low1]) {
                int min = (low2 + high2) / 2;
                if (nums[min] == target) {
                    return min;
                }
                else if (nums[min] < target) {
                    low2 = min + 1;
                }
                else {
                    high2 = min - 1;
                }
            }
            else {
                int min = (low1 + high1) / 2;
                if (nums[min] == target) {
                    return min;
                }
                else if (nums[min] < target) {
                    low1 = min + 1;
                }
                else {
                    high1 = min - 1;
                }
            }
        }
        return -1;
    }
    public static int search1 (int[] nums, int target) {
        int low = 0; int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            else if (target > nums[mid]) {
                if (target >= nums[low] && nums[mid] < nums[low]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }

            }
            else {
                if (target <= nums[low] && nums[mid] < nums[high]) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }

            }
        }
        return -1;
    }
    // solution fo discussing 
    public int search2(int[] A, int target) {
        int lo = 0;
        int hi = A.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (A[mid] == target) return mid;

            if (A[lo] <= A[mid]) {
                if (target >= A[lo] && target < A[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target > A[mid] && target <= A[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return A[lo] == target ? lo : -1;
    }
    public static void main (String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 4;
        System.out.println(search1(nums, target));
    }
}
