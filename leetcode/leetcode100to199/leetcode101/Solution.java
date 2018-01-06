package leetcode100to199.leetcode101;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymetric(root.left, root.right);
    }
    private boolean isSymetric(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        else if (root1 == null || root2 == null) {
            return false;
        }
        return isSymetric(root1.left, root2.right) && isSymetric(root1.right, root2.left) && root1.val == root2.val;
    }
}
