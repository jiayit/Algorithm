package leetcode26;

class Solution {
    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i;
        for (i = 0; i < length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                continue;
            }
            else {
                int x = nums[i];
                for (int j = i + 1; j < length; j++) {
                    nums[j - 1] = nums[j];
                }
                nums[length - 1] = x;
                length--;
                i = 0;

            }
        }
        return length;
    }
    public int removeDuplicates1(int[] A) {
        if (A.length==0) return 0;
        int j=0;
        for (int i=0; i<A.length; i++)
            if (A[i]!=A[j]) A[++j]=A[i];
        return ++j;
    }
    public static void main (String[] args) {
        int[] nums = {1,1,1,1,1,1,2};
        System.out.println(removeDuplicates(nums));
    }
}