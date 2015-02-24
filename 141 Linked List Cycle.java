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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head, fast = head;
        
        while(fast != null){
            fast = fast.next;
            if(fast == null) break;
            if(fast == slow) return true;
            fast = fast.next;
            slow = slow.next;
        }
        return false;
    }
}
