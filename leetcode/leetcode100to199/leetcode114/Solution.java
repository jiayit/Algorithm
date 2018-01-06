package leetcode100to199.leetcode114;

import java.util.LinkedList;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    // stack
    public static void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root;
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (node != null || !stack.isEmpty()) {
            if (node != null && node.right != null) {
                stack.push(node.right);
            }
            if (node != null && node.left != null) {
                TreeNode node1 = node;
                node.right = node.left;
                node = node.left;
                node1.left = null;
                continue;
            }
            if (!stack.isEmpty()) {
                node.right = stack.pop();
            }
            node = node.right;
        }
    }
    //recursion
    private TreeNode prev = null;
    public void flatten1(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);

        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode right = new TreeNode(6);
        root.right = node4;
        root.left = node1;
        node1.left = node2;
        node1.right = node3;
        node4.right = right;
        flatten(root);
    }

}
