package leetcode88;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums = new int[m];
        if (n == 0) {
            return;
        }
        for (int i = 0; i < m; i++) {
            nums[i] = nums1[i];
        }

        for (int i = 0, s = 0, h = 0; i < m + n; i++) {
            if (h < n && (s >= m || nums[s] > nums2[h])) {
                nums1[i] = nums2[h++];
            }
            else if (s < m  && (h >= n || nums[s] <= nums2[h])) {
                nums1[i] = nums[s++];
            }
        }
    }
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        int s = m - 1;
        int h = n - 1;
        while (s >= 0 && h >= 0) {
            if (nums1[s] > nums2[h]) {
                nums1[i--] = nums1[s--];
            }
            else {
                nums1[i--] = nums2[h--];
            }
        }
        while (h >= 0) {
            nums1[i--] = nums2[h--];
        }
    }
    public static void main (String[] args) {
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        merge1(nums1, 1, nums2, 1);
        for (int num : nums1) {
            System.out.print(num);
        }
    }
}