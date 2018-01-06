package leetcode47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), new boolean[nums.length], nums);
        return list;
    }
    private static void backtrack (List<List<Integer>> list, List<Integer> tempList, boolean[] used, int[] nums) {
        int length = nums.length;
        if (tempList.size() == length) {
            list.add(new ArrayList<>(tempList));
            return;
        }
        for (int i = 0; i < length; i++) {
            //            if (!used[i]) {
            //                if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
            //                    continue;
            //                }
            if (used[i] || i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backtrack(list, tempList, used, nums);
            tempList.remove(tempList.size() - 1);
            used[i] = false;
            //            }
        }
    }
    public static void main (String[] args) {
        int[] nums = {1,1,2};
        List<List<Integer>> list = permuteUnique(nums);
        for (List<Integer> list2 : list) {
            for (int num : list2) {

                System.out.print(num);
            }
            System.out.println("");
        }
    }
}
