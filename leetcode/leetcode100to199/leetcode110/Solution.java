package leetcode100to199.leetcode110;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public static boolean isBalanced(TreeNode root) {
        int dep = depth(root);
        if (dep == Integer.MAX_VALUE) {
            return false;
        }
        return true;
    }
    private static int depth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == Integer.MAX_VALUE || right == Integer.MAX_VALUE || Math.abs(left - right) > 1) {
            return Integer.MAX_VALUE;
        }
        return 1 + Math.max(left, right);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);
        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        root.right = node4;
        node4.right = node5;
        node5.right = node6;
        System.out.println(isBalanced(root));
    }

}
