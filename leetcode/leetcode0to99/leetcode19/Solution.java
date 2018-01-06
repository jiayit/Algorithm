package leetcode19;

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
        val = x;
    }
} 
class Solution {
    public  static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }
        ListNode listNode1 = head;
        int length = 0;
        while (listNode1 != null) {
            length++;
            listNode1 = listNode1.next;
        }
        if (length == n) {
            return head.next;
        }
        ListNode listNode2 = head;
        ListNode lastNode = head;
        for (int i = 0; i < length - n; i++) {
            lastNode = listNode2;
            listNode2 = listNode2.next;
        }

        lastNode.next = listNode2.next;
        return head;
    }
    public  static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode start = new ListNode(0);
        ListNode slow = start, fast = start;
        slow.next = head;

        //Move fast in front so that the gap between slow and fast becomes n
        for(int i=1; i<=n+1; i++)   {
            fast = fast.next;
        }
        //Move fast to the end, maintaining the gap
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        //Skip the desired node
        slow.next = slow.next.next;
        return start.next;
    }
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode head = removeNthFromEnd(listNode, 3);
        while (head != null) {

            System.out.println(head.val);
            head = head.next;
        }
    }
}