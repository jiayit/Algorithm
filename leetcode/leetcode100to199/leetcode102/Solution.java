package leetcode100to199.leetcode102;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    //DFS
    public static List<List<Integer>> levelOrder(TreeNode root) {
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        traversal(root, 1, hashMap);
        for (List<Integer> li : hashMap.values()) {
            list.add(li);
        }
        return list;
    }
    private static void traversal (TreeNode root, int depth, HashMap<Integer, List<Integer>> map) {
        if (root == null) {
            return;
        }
        if (map.get(depth) == null) {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(depth, list);
        }
        else {
            List<Integer> list = map.get(depth);
            list.add(root.val);
        }
        traversal(root.left, depth + 1, map);
        traversal(root.right, depth + 1, map);
    }
    // BFS
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return list;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            int nodeNum = queue.size();
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
            list.add(tempList);
        }
        return list;
    }
    public static void main (String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        List<List<Integer>> list = levelOrder(root);
        for (List<Integer> li : list) {
            for (int x : li) {
                System.out.print(x);
            }
            System.out.println();
        }
    }
}
