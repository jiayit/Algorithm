package leetcode100to199.leetcode100;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if (p == null || q == null) {
            return false;
        }
        if (isSameTree(p.left, q.left) && p.val == q.val && isSameTree(p.right, q.right)) {
            return true;
        }
        return false;
    }
}
