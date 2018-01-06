package leetcode90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    // recurtion
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack (list, new ArrayList(), nums, 0);
        return list;
    }
    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        if (!list.contains(tempList)) {
            list.add(new ArrayList(tempList)); 
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
    // brute force
    public static List<List<Integer>> subsetsWithDup1(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        list.add(new ArrayList<>());
        int start = 0;
        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = size;
            }
            size = list.size();
            List<Integer> tempList;

            for (int j = start; j < size; j++) {
                tempList = new ArrayList<>(list.get(j));
                tempList.add(nums[i]);
                list.add(new ArrayList<>(tempList));
            }
        }
        return list;
    }
    public static void main (String[] args) {
        int[] nums = {1,2,2};
        subsetsWithDup(nums);
        System.out.println();
    }
}