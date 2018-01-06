package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int lo  = i + 1; int hi = length - 1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] + nums[i] == 0) {
                        list.add(Arrays.asList( nums[i], nums[lo], nums[hi]));

                        while (lo < hi &&nums[lo] == nums[lo + 1]) {
                            lo++;
                        }
                        while (lo < hi && nums[hi] == nums[hi - 1]) {
                            hi--;
                        }
                        lo++;
                        hi--;
                    }
                    else if (nums[lo] + nums[hi] + nums[i] < 0) {
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }

        return list;

    }

    public static void main (String[] args) {
        int[] nums = {};
        List<List<Integer>> list = threeSum(nums);
        for (List list2 : list) {
            int i = 0;
            while (i < 3) {
                System.out.print(list2.get(i++));
            }
            System.out.println("");
        }
    }


}
