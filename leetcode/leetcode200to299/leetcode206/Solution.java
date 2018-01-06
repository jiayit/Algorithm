package leetcode206;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        // TODO Auto-generated constructor stub
        this.val = val;
    }
}
public class Solution {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        ListNode last = null;
        ListNode next;
        while (node != null) {
            next = node.next;
            node.next = last;
            last = node;
            node = next;
        }
        return last;
    }
    public static ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return reverseList2(head, null);
    }
    public static ListNode reverseList2(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;
        reverseList2(next, newHead);
        return newHead;
    }
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode  node = reverseList(listNode);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
