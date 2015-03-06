/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode h = head;
        ListNode last = h;
        h = h.next;
        
        while(h != null){
            if(h.val != last.val){
                last = h;
            }
            else{
                last.next = h.next;
            }
            h = h.next;
        }
        return head;
    }
}
