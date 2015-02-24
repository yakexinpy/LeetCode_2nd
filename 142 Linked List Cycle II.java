/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return head;
        ListNode slow = head, fast = head;
        while(fast != null){
            fast = fast.next;
            if(fast == null) return null;
            fast = fast.next;
            if(fast == null) return null;
            slow = slow.next;
            if(fast == slow) break;
        }
        
        if(fast == head) return head;
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
