package leetcode46;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<Integer>(), nums);
        return list;
    }
    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, int[] nums) {
        int length = nums.length;
        if (tempList.size() == length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!tempList.contains(nums[i])) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    public static void main (String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> list = permute(nums);
        for (List<Integer> list2 : list) {
            for (int num : list2) {

                System.out.print(num);
            }
            System.out.println("");
        }
    }
}
