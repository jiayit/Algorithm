package leetcode100to199.leetcode106;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return constructTree(postorder.length - 1, 0, inorder.length - 1, postorder, inorder);
    }
    private TreeNode constructTree(int postEnd, int inStart, int inEnd, int[] postorder, int[] inorder) {
        if (inStart > inEnd || postEnd < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postEnd]);
        int rootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                rootIndex = i;
                break;
            }
        }
        root.right = constructTree(postEnd - 1, rootIndex + 1, inEnd, postorder, inorder);
        root.left = constructTree(postEnd - 1 - (inEnd - rootIndex), inStart, rootIndex - 1, postorder, inorder);
        return root;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
