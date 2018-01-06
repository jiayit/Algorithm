package leetcode100to199.leetcode113;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, list, new ArrayList<>(), sum);
        return list;
    }
    private void dfs (TreeNode root, List<List<Integer>> list, List<Integer> tempList, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null && sum == root.val) {
            tempList.add(root.val);
            list.add(new ArrayList<>(tempList));
            return;
        }
        tempList.add(root.val);
        if (root.left != null) {
            dfs(root.left, list, tempList, sum - root.val);
            tempList.remove(tempList.size() - 1); 
        }
        if (root.right != null) {
            dfs(root.right, list, tempList, sum - root.val);
            tempList.remove(tempList.size() - 1);
        }
    }
}
