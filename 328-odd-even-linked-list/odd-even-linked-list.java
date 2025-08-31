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
    public ListNode oddEvenList(ListNode head) {
        if(head == null){
            return null;
        }

        ListNode odd = head , even = head.next;
        ListNode temp = odd , curr = even;
        while(curr != null && curr.next != null && temp != null && temp.next != null){
            temp.next = curr.next;
            temp = curr.next;
            curr.next = temp.next;
            curr = temp.next;
        }
        temp.next = even;
        return odd;
    }
}