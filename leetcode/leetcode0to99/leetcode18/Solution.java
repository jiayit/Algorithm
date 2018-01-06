package leetcode18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < length - 3; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1] )) {
                for (int j = i + 1; j < length - 2; j++) {
                    if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
                        int lo = j + 1; int hi = length - 1;
                        while (lo < hi) {
                            if (nums[i] + nums[j] + nums[lo] + nums[hi] == target) {
                                list.add(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));

                                while (lo < hi && nums[lo] == nums[lo + 1]) {
                                    lo++;
                                }
                                while (lo < hi && nums[hi] == nums[hi - 1]) {
                                    hi--;
                                }
                                lo++;
                                hi--;
                            }
                            else if (nums[i] + nums[j] + nums[lo] + nums[hi] < target) {
                                lo++;
                            }
                            else {
                                hi--;
                            }
                        }
                    }
                }
            }
        }
        return list;
    }
    public  static void main (String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 1;
        System.out.println(fourSum(nums, target));
    }
}