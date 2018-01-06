package leetcode39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> listall = new LinkedList<>();
        Arrays.sort(candidates);
        int min = candidates[0];
        int max = candidates[candidates.length - 1];
        listall = combination(candidates, max, min, target);
        return listall;
    }
    public static List<List<Integer>> combination (int[] candidates, int max , int min, int target) {
        List<List<Integer>> listall = new LinkedList<>();
        for (int i = 1; i <= target / 2; i++) {
            if (i < min || target - i < min) {
                continue;
            }
            List<List<Integer>> list1 = combination(candidates, max, min, i);
            List<List<Integer>> list2 = combination(candidates, max, min, target - i);
            for (List<Integer> li1 : list1) {
                for (List<Integer> li2 : list2) {
                    List<Integer> lIntegers = new LinkedList<>();
                    for (int x : li1) {
                        lIntegers.add(x);
                    }
                    for (int x : li2) {
                        lIntegers.add(x);
                    }
                    Collections.sort(lIntegers);
                    if (listall.contains(lIntegers)) {
                        continue;
                    }
                    listall.add(lIntegers);

                }

            }

        }
        if (target >= min && target <= max) {
            for (int i = 0; i < candidates.length; i++) {
                if (target == candidates[i]) {
                    List<Integer> list1 = new LinkedList<>();
                    list1.add(candidates[i]);
                    listall.add(list1);
                    return listall;
                }

            }

        }
        return listall;
    }
    // backtrack
    public static List<List<Integer>> combinationSum1(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<Integer>(), nums, target, 0);
        return list;
    }

    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, int[] nums, int target, int start) {
        if (target > 0) {
            for (int i = start; i < nums.length && target >= nums[i]; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums,  target - nums[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
        else if (target == 0) {
            list.add(new ArrayList<>(tempList));
        }
        else {
            return;
        }
    }
    public static void main (String[] args) {
        int[] nums = {2,3,6,7};
        int target = 6;
        for (List list : combinationSum1(nums, target)) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println("");

        }
    }
}