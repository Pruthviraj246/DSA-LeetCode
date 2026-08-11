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
// class Solution {
//     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//         ListNode dummy=new ListNode();
//         ListNode tail=dummy;

//        while (list1!= null && list2!= null){
//             if(list1.val<=list2.val){
//                 tail.next=list1;
//                 list1=list1.next;
//                 tail=tail.next;
//             }else{
//                 tail.next=list2;
//                 list2=list2.next;
//                 tail=tail.next;
//             }
//         }
//         if(list1!=null){
//             tail.next=list1;
//         }else{
//             tail.next=list2;
//         }
//         return dummy.next;

//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1==null){
            return list2;
        }
        if(list2==null){
            return list1;
        }
        if(list1.val>list2.val){
            ListNode temp=list1;
            list1=list2;
            list2=temp;
        }
        ListNode head=list1;

        ListNode temp1=list1;
        ListNode temp2=list2;
       while (temp1.next != null && temp2 != null) {
            if (temp1.next.val <= temp2.val) {
                temp1=temp1.next;
            }else{
                ListNode next=temp1.next;
                temp1.next=temp2;
                temp2=temp2.next;
                temp1.next.next=next;
                temp1=temp1.next;
            }
        }
        if (temp2!=null) {
            temp1.next=temp2;
        }
        return list1;
    }
}