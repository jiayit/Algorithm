package leetcode100to199.leetcode112;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return pathSum(root, sum, 0);
    }
    private boolean pathSum(TreeNode root, int sum, int count) {
        if (root == null) {
            return false;
        } 
        if (count + root.val == sum && root.left == null && root.right == null) {
            return true;
        }     
        return pathSum(root.left, sum, count + root.val) ||  pathSum(root.right, sum, count + root.val);
    }
}
