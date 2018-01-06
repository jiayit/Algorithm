package leetcode86;

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
    public static ListNode partition(ListNode head, int x) {
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        ListNode less = newHead;
        ListNode greater = newHead;
        ListNode last = newHead;
        ListNode cur = head;

        if (cur != null && cur.val < x) {
            less = head;
        }
        else {
            greater = head;
        }
        while (cur != null) {
            if (cur.val < x) {
                if (less.next == greater) {
                    less.next = cur;
                    last.next = cur.next;
                    cur.next = greater;
                    less = less.next;
                    cur = last .next;
                }
                else {
                    less = cur;
                    cur = cur.next;
                }
            }
            else {
                if (less.next != greater) {
                    greater = cur;
                }
                last = cur;
                cur = cur.next;
            }

        }
        return newHead.next;
    }
    public static ListNode partition1(ListNode head, int x) {
        ListNode listNode1 = new ListNode(0);
        ListNode listNode2 = new ListNode(0);
        ListNode s1 = listNode1;
        ListNode s2 = listNode2;
        while (head != null) {
            if (head.val < x) {
                s1.next = head;
                s1 = s1.next;
            }
            else {
                s2.next = head;
                s2 = s2.next;
            }
            head = head.next;
        }
        s2.next = null;
        s1.next = listNode2.next;
        return listNode1.next;
    }
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(4);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = new ListNode(3);
        listNode.next.next.next.next.next = new ListNode(1);

        ListNode  node = partition1(listNode, 4);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }
}