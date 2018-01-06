package leetcode24;

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
    public ListNode(int x) {
        // TODO Auto-generated constructor stub
        val= x;
    }
}
class Solution {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = head;
        ListNode head1 = head.next;
        int count = 1;
        ListNode before = head;
        while (listNode != null && listNode.next!= null) {
            ListNode last = listNode;
            listNode = listNode.next;
            ListNode next = listNode.next;
            listNode.next = last;
            last.next = next;
            if (before != last) {                
                before.next = listNode;
            }

            before = last;
            listNode = last.next;

        }
        return head1;
    }
    public ListNode swapPairs1(ListNode head) {
        if ((head == null)||(head.next == null))
            return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
    public static void main (String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(3);
        listNode1.next.next.next = new ListNode(4);
        ListNode listNode = null;
        listNode1 = swapPairs(listNode);
        while (listNode1 != null) {
            System.out.println(listNode1.val);
            listNode1 = listNode1.next;
        }
        System.out.println();
    }
}