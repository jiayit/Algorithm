package leetcode100to199.leetcode142;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
class Cycle {
    //brute force O(n2)
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null; 
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != slow) return null;
        ListNode start = head;
        while (start != slow) {
            boolean flag = false;
            ListNode node = slow.next;
            while (node != slow) {
                if (start == node) {
                    flag = true;
                    break;
                }
                node = node.next;
            }
            if (flag) return start;
            start = start.next;
        }
        return start;
    }
    //2k - k = nr O(n)
    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) return null; 
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }
        if (fast != slow) return null;
        ListNode start = head;
        while (start != slow) {
            start = start.next;
            slow = slow.next;
        }
        return start;
    }
}
public class Solution {

}
