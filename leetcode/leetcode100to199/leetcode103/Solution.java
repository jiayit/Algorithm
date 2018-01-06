/**
 * 
 */
package leetcode100to199.leetcode103;

import java.util.LinkedList;
import java.util.List;


/**
 * @author jiayit
 *
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public final class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            LinkedList<Integer> tempList = new LinkedList<>();
            for (int i = 0; i < nodeNum; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                if (count % 2 != 0) {
                    tempList.push(node.val);
                }
                else {
                    tempList.add(node.val);
                }
            }
            list.add(tempList);
            count++;
        }
        return list;
    }

}
