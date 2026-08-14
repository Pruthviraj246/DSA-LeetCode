/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode previous=null;
        ListNode present=head;
        

        while (present!=null){
            ListNode future=present.next;
            present.next=previous;
            previous=present;
            present=future;
            if (future!=null){
                future=future.next;
            }
        }
        return previous;
    }
}