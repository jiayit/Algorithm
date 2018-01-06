package leetcode21;

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
    ListNode(int x) {
        val = x;
    }
}
class Solution {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }

        ListNode listNode;
        if (l1.val <= l2.val) {

            listNode = l1;
            l1 = l1.next;
        }
        else {
            listNode = l2;
            l2 = l2.next;
        }
        ListNode node = listNode;

        while (l1 != null && l2!= null) {
            if (l1.val <= l2.val) {
                node.next = l1;
                node = node.next;
                l1 = l1.next;
                continue;
            }
            else {
                node.next = l2;
                node = node.next;
                l2 = l2.next;
            }

        }
        while (l1!= null) {
            node.next = l1;
            node = node.next;
            l1 = l1.next;
            continue;
        }
        while (l2 != null) {
            node.next = l2;
            node = node.next;
            l2 = l2.next;
        }
        return listNode;
    }
    // recursion
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
    public static void main (String[] args) {
        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(3);
        listNode1.next.next = new ListNode(4);
        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(5);
        listNode2.next.next = new ListNode(6);

        ListNode result = mergeTwoLists(listNode1, listNode2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}