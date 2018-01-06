package leetcode100to199.leetcode116;

import java.util.LinkedList;


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    // BFS
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int nodeNum = queue.size();
            TreeLinkNode node = null;
            for (int i = 0; i < nodeNum; i++) {
                queue.peek().next = node;
                node = queue.pop();
                if (node.right != null && node.left != null) {
                    queue.add(node.right);
                    queue.add(node.left);
                }
            }
        }
    }
    public static void connect1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode cur = levelStart;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                    if (cur.next != null) {
                        cur.right.next= cur.next.left;
                    }
                }
                cur = cur.next;
            }
            levelStart = levelStart.left;
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode node1 = new TreeLinkNode(2);
        TreeLinkNode node2 = new TreeLinkNode(3);

        TreeLinkNode node3 = new TreeLinkNode(4);
        TreeLinkNode node4 = new TreeLinkNode(5);
        TreeLinkNode node5 = new TreeLinkNode(6);
        TreeLinkNode node6 = new TreeLinkNode(7);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        connect(root);
    }
}
