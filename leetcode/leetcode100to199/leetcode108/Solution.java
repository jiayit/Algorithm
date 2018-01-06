package leetcode100to199.leetcode108;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return constructTree(nums, 0, nums. length - 1);
    }
    private TreeNode constructTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructTree(nums, start,mid - 1);
        root.right = constructTree(nums, mid + 1, end);
        return root;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
