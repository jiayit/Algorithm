package leetcode100to199.leetcode107;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            List<Integer> tempList = new ArrayList<>();
            for (int i = 0; i < nodeNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                tempList.add(node.val);
            }
            list.add(0, tempList);
        }
        return list;
    }

}
