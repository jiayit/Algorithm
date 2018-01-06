package leetcode61;

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
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        ListNode listNode = head;
        int n = 1;
        while (listNode.next != null) {
            listNode = listNode.next;
            n++;
        }
        k = k % n;
        if (k == 0) {
            return head;
        }
        ListNode oldHead = head;
        ListNode leftNode = head;
        for (int i = 1; i < n - k; i++) {
            leftNode = leftNode.next;
        }
        head = leftNode.next;
        ListNode rightNode = head;
        for (int i = 1; i < k; i++) {
            rightNode = rightNode.next;
        }
        rightNode.next = oldHead;
        leftNode.next = null;
        return head;
    }
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        ListNode listNode2 = rotateRight(listNode, 6);
        while (listNode2 != null) {            
            System.out.print(listNode2.val);
            listNode2 = listNode2.next;
        }
    }
}