package leetcode60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // recursion
    public static String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        backtrack(list, new String(), new ArrayList<>(), nums);
        return list.get(k - 1);
    }
    private static void backtrack(List<String> list, String string, List<String> tempList, int[] nums) {
        if (string.length() == nums.length) {
            list.add(string);
            return;
        }
        String string2 = string;
        for (int i = 0; i < nums.length; i++) {
            if (!tempList.contains(nums[i] + "")) {
                string2 = string2 + nums[i];
                tempList.add(nums[i] + "");
                backtrack(list, string2, tempList, nums);
                string2 = string;
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static String getPermutation1 (int n, int k) {
        String string = "";
        int[] nums = new int[n];
        int[] factorial = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            if (i > 1) { 
                factorial[i] = factorial[i - 1] * i;
            }
            else {
                factorial[i] = i;
            }
        }
        int x = 0;
        int y = 0;
        k = k - 1;
        for (int i = n - 1; i >= 1; i--) {

            x = k / factorial[i];
            if (x >= 1) {
                swap(nums, n - i - 1, n - i - 1 + x);
                Arrays.sort(nums, n - i, n);
            }
            k = k % factorial[i];
        }

        for (int i = 0; i < n; i++) {
            string = string + nums[i];
        }
        return string;
    }
    private static void swap (int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public static void main (String[] args) {
        int n = 4;
        int k = 24;
        System.out.println(getPermutation1(n, k));
    }
}