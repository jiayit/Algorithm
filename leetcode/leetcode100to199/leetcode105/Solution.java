package leetcode100to199.leetcode105;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        return constructTree(0, 0, inorder.length - 1, preorder, inorder);
    }
    private static TreeNode constructTree (int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart >= preorder.length || inStart > inEnd ) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int rootNum = 0;
        for (int i = inStart;i <= inEnd; i++) {
            if (inorder[i] == preorder[preStart]) {
                rootNum = i;
                break;
            }
        }
        root.left = constructTree(preStart + 1, inStart, rootNum - 1, preorder, inorder);
        root.right = constructTree(preStart + rootNum - inStart + 1, rootNum + 1, inEnd, preorder, inorder);
        return root;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] preorder = {1,2,3,4,5};
        int[] inorder = {3,2,4,1,5};
        buildTree(preorder, inorder);
    }

}
