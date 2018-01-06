package leetcode100to199.leetcode109;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        // TODO Auto-generated constructor stub
        this.val = val;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    ListNode node;
    public TreeNode sortedListToBST(ListNode head) {
        node = head;
        ListNode tempNode = head;
        int count = 0;
        while (tempNode != null) {
            count++;
            tempNode = tempNode.next; 
        }
        return constructTree(1, count);
    }
    private TreeNode constructTree(int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode left = constructTree(start, mid - 1);
        TreeNode root = new TreeNode(node.val);
        root.left = left;
        node = node.next;
        root.right = constructTree(mid + 1, end);
        return root;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
