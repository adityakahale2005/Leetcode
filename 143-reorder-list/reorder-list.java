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
     public ListNode middleNode(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
    
            while(fast != null && fast.next != null){
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
            
        }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode hs = reverseList(mid); //head second
        ListNode hf = head; // head first

    while(hf != null && hs != null){
        ListNode temp = hf.next;
        hf.next = hs;
        hf = temp;

        ListNode tempo = hs.next;
        hs.next = hf;
        hs = tempo;
    }  
     if (hf != null) {
        hf.next = null;
    }
    }
    }