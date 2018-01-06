package leetcode75;

class Solution {
    // insertion sort
    public static void sortColors(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
            }
        }
    }
    private static void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    // mergesort
    public static void sortColors1 (int[] nums) {
        int length = nums.length;
        int[] b = new int[length];
        sort(nums, b, 0, length - 1);
    }
    public static void sort (int[] a, int[] b, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = (lo + hi) / 2;
        sort(a, b, lo, mid);
        sort(a, b, mid + 1, hi);
        merge(a, b, lo, mid, hi);
    }
    private static void merge (int[]a, int[] b, int lo, int mid, int hi) {
        for (int i = lo; i <= hi; i++) {
            b[i] = a[i];
        }
        int i = lo; int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = b[j++];
            }
            else if (j > hi) {
                a[k] = b[i++];
            }
            else if (b[j] < b[i]) {
                a[k] = b[j++];
            }
            else {
                a[k] = b[i++];
            }
        }
    }
    // Quicksort 3-way
    public static void sortColors2 (int[] nums) {
        int length = nums.length;
        sort(nums, 0, length - 1);
    }
    private static void sort (int[] nums, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int lt = lo; 
        int i = lo;
        int gt = hi;
        int v = nums[lo];
        while (i <= gt) {
            if (nums[i] < v) {
                swap(nums, i++, lt++);
            }
            else if (nums[i] > v) {
                swap(nums, i, gt--);
            }
            else {
                i++;
            }
        }
        sort(nums, lo, lt - 1);
        sort(nums, i, hi);
    }

    public static void main (String[] args) {
        int[] nums = {0,2,1,1,0,2};
        sortColors2(nums);
        for (int color : nums) {
            System.out.print(color);
        }

    }
}