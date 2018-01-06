package leetcode92;

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        // TODO Auto-generated constructor stub
        this.val = val;
    }
}
public class Solution {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {

        }
        ListNode node = head;
        int count = 0;
        ListNode before = new ListNode(0);
        before.next = head;
        ListNode last = null;
        ListNode first = null;
        while (node != null) {
            count++;
            ListNode next = node.next;
            if (count == m - 1) {
                before = node;
            }
            else if (count == m) {
                first = node;
            }
            else if (count == n) {
                before.next = node;
                node.next = last;
            }
            else if (count == n + 1) {
                first.next = node;
            }
            else if (count > m && count < n){
                node.next = last;
            }
            last = node;
            node = next;
        }
        if (count == n) {
            first.next = node;
        }
        if (m == 1) {
            return before.next;
        }
        return head;
    }
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        ListNode  node = reverseBetween(listNode, 1, 3);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
