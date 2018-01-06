package leetcode40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(), candidates, target, 0);
        return list;
    }
    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, int[] nums, int target, int start) {
        if (target > 0) {
            for (int i = start; i < nums.length && target >= nums[i]; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, target - nums[i], i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
        else if (target == 0) {
            if (!list.contains(tempList)) {
                list.add(new ArrayList<>(tempList));
            }
        }
        else {
            return;
        }
    }

    public static void main (String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int target = 8;
        for (List list : combinationSum2(nums, target)) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println("");

        }
    }
}