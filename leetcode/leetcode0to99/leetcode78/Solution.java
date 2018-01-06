package leetcode78;

import java.util.ArrayList;
import java.util.List;

class Solution {
    // recursion 1
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());
        for (int n = 1; n <= nums.length; n++) {
            backtrack(list, new ArrayList<>(), n, nums, 0);
        }
        return list;
    }
    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, int size, int[] nums, int start) {
        if (tempList.size() == size) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, size, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    // recursion 2
    public static List<List<Integer>> subsets1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }
    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    } 
    public static void main (String[] args) {
        int[] nums = {1,2,3};
        for (List<Integer> list : subsets(nums)) {
            for (int x : list) {
                System.out.print(x);
            }
            System.out.println();
        }
        System.out.println();
    }
}