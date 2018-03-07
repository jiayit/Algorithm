package leetcode200to299.leetcode239;

import java.util.ArrayDeque;
import java.util.Deque;

class MaxNum {
    public void add(Deque<Integer> deque, int num) {
        while (!deque.isEmpty() && deque.peekLast() < num) {
            deque.removeLast();
        }
        deque.add(num);
    }
    public void remove(Deque<Integer> deque, int num) {
        if (deque.peek() == num) {
            deque.poll();
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) { 
        Deque<Integer> deque = new ArrayDeque<>();
        int len = nums.length;
        
        int[] ans = new int[len - k + 1];
        if (len == 0) {
            return new int[0];
       }
        for (int i = 0; i < k - 1; i++) {
            add(deque, nums[i]);
        }
        for (int i = k - 1; i < len; i++) {
            add(deque, nums[i]);
            ans[i - k + 1] = deque.peek();
            remove(deque, nums[i - k + 1]);
        }
        return ans;
    }
}
public class Solution {
	public static void main (String[] args) {
		MaxNum maxNum = new MaxNum();
		int[] nums = {1,3,-1,-3,5,3,6,7};
		maxNum.maxSlidingWindow(nums, 3);
	}
}
