package leetcode98;

import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        int[] nums = recursive(root);
        if (nums[0] > nums[1]) {
            return false;
        }
        return true;
    }
    private static int[] recursive(TreeNode root) {
        int[] nums = new int[2];
        if (root.left == null && root.right == null) {
            nums[0] = root.val;
            nums[1] = root.val;
            return nums;
        }
        int[] numsLeft;
        int[] numsRight;
        if (root.left == null) {
            numsRight = recursive(root.right);
            if (root.val < numsRight[0] && root.val < numsRight[1]) {
                nums[0] = root.val;
                nums[1] = numsRight[1];
                return nums;
            }
        }
        else if (root.right == null) {
            numsLeft = recursive(root.left);
            if (root.val > numsLeft[1] && root.val > numsLeft[0]) {
                nums[0] = numsLeft[0];
                nums[1] = root.val;
                return nums;
            }
        }
        else {
            numsLeft = recursive(root.left);
            numsRight = recursive(root.right);
            if (root.val > numsLeft[1]  && root.val > numsLeft[0] && root.val < numsRight[0] && root.val < numsRight[1]) {
                nums[0] = numsLeft[0];
                nums[1] = numsRight[1];
                return nums;
            }
        }
        nums[0] = Integer.MAX_VALUE;
        nums[1] = Integer.MIN_VALUE;
        return nums;
    }
    // inorder traversal : using stack
    public static boolean isValidBST1(TreeNode root) {
        TreeNode node = root;
        TreeNode pre = null;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            if (pre != null && pre.val >= node.val) {
                return false;
            }
            pre = node;
            node = node.right;
        }
        return true;
    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(Integer.MIN_VALUE);
        TreeNode node1 = new TreeNode(Integer.MAX_VALUE);
        TreeNode node2 = new TreeNode(Integer.MIN_VALUE);
        //        TreeNode right = new TreeNode(3);
        TreeNode node3 = new TreeNode(Integer.MAX_VALUE);
        //        TreeNode node4 = new TreeNode(20);
        root.right = node1;
        node1.left = node2;
        //        node2.right = node4;
        node1.right = node3;
        //        root.right = right;
        System.out.println(isValidBST(root));
    }
}
