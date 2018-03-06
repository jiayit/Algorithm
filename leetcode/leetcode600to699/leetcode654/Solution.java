package leetcode600to699.leetcode654;

import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;     
    TreeNode(int x) { val = x; }
}
class MaxTree {
    public TreeNode constructMaximumBinaryTree1(int[] nums) {
        Deque<TreeNode> stack = new LinkedList<>();
        for(int i = 0; i < nums.length; i++) {
            TreeNode curr = new TreeNode(nums[i]);
            while(!stack.isEmpty() && stack.peek().val < nums[i]) {
                curr.left = stack.pop();
            }
            if(!stack.isEmpty()) {
                stack.peek().right = curr;
            }
            stack.push(curr);
        }
        
        return stack.isEmpty() ? null : stack.removeLast();
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return null;
        }
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        int index = 0;
        stack.push(new TreeNode(nums[index]));
        TreeNode root = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            TreeNode right = null;
            if (index < len - 1) {
                right = new TreeNode(nums[index + 1]);
            }
            else {
                right = new TreeNode(Integer.MAX_VALUE);
                index++;
            }
            if (right.val > node.val) {
                root = stack.pop();
                if (!stack.isEmpty()) {
                    TreeNode left = stack.peek();
                    if (left.val > right.val) {
                        right.left = node;
                    }
                    else {
                        left.right = node;
                        continue;
                    }
                    
                }
                else {

                    right.left = node;
                }
            }

            if (index < len) {
                stack.push(right);  
              }
        	index++;
        }
        return root;
    }
}
public class Solution {
	public static void main(String[] args) {
		MaxTree tree = new MaxTree();
		int[] nums = {3,2,1,6,0,5}; 
		TreeNode maxTree = tree.constructMaximumBinaryTree1(nums);
	}
}
