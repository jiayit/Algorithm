package leetcode82;

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
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = head;
        ListNode last = head;
        ListNode latest = head;
        while (listNode.next != null) {
            if (listNode.val == listNode.next.val) {
                if (listNode == head) {
                    latest = head;
                    head = head.next;
                    listNode = head;
                }
                else {
                    latest = listNode;
                    listNode = listNode.next;
                }
            }
            else if (latest != head && listNode.val == latest.val) {
                if (listNode == head) {
                    latest = head;
                    head = head.next;
                    listNode = head;
                }
                else {
                    last.next = listNode.next;
                    latest = listNode;
                    listNode = listNode.next;
                }

            }
            else {

                last = listNode;
                latest = listNode;
                listNode = listNode.next;
            }
        }
        if (latest.val == listNode.val) {
            if (listNode == head) {
                head = head.next;
                listNode = head;
            }
            else {
                last.next = listNode.next;
            }
        }
        return head;
    }
    // solution of discussing
    public ListNode deleteDuplicates1(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    } 
    public static void main (String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(5);
        ListNode  node = deleteDuplicates(listNode);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }

}