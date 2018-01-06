package leetcode100to199.leetcode104;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        depth = maxDepth(root, 0);
        return depth;
    }
    private static int maxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        depth = depth + 1;
        int depth1 = maxDepth(root.left, depth); 
        int depth2 = maxDepth(root.right, depth);
        return depth1 > depth2 ? depth1 : depth2;
    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node3.right = node4;

        System.out.println(maxDepth(root));
    }
}
