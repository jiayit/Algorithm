package leetcode100to199.leetcode117;


class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class Solution {
    public static void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode curStart = levelStart;
            TreeLinkNode cur = levelStart;
            TreeLinkNode pre = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                        pre = cur.left;
                    }
                    else {
                        levelStart = cur.left;
                        pre = cur.left;
                    }
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                        pre = cur.right;
                    }
                    else {
                        levelStart = cur.right;
                        pre = cur.right;
                    }
                }
                cur = cur.next;
            }
            if (levelStart == curStart) {
                levelStart = null;
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeLinkNode root = new TreeLinkNode(-9);
        TreeLinkNode node1 = new TreeLinkNode(-3);
        TreeLinkNode node2 = new TreeLinkNode(2);

        TreeLinkNode node3 = new TreeLinkNode(4);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(0);
        TreeLinkNode node6 = new TreeLinkNode(-6);
        TreeLinkNode node7 = new TreeLinkNode(-5);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node4.left = node7;
        connect(root);
    }
}
