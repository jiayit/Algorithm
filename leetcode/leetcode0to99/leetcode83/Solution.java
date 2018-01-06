package leetcode83;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        // TODO Auto-generated constructor stub
        this.val = val;
    }
}
class Solution {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode node = head;
        while (node != null && node.next != null) {
            while (node != null && node.next != null && node.val == node.next.val) {
                node.next = node.next.next;
            }
            node = node.next;
        }
        return head;
    }
    // recursion
    public static ListNode deleteDuplicates1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = deleteDuplicates1(head.next);
        return head.val == head.next.val ? head.next : head;
    }
    public static void main (String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(1);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(3);
        ListNode head = deleteDuplicates1(node);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }

    }
}