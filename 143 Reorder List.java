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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        ListNode slow = head, fast = head, pre = slow;
        
        while(fast != null && fast.next != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        
        ListNode fake = new ListNode(-1);
        while(slow != null){
            ListNode tmp = slow.next;
            slow.next = fake.next;
            fake.next = slow;
            slow = tmp;
        }
        
        ListNode node = fake;
        fast = head;
        slow = fake.next;
        while(fast != null && slow != null){
            node.next = fast;
            fast = fast.next;
            node = node.next;
            
            node.next = slow;
            slow = slow.next;
            node = node.next;
        }
        if(fast != null)
            node.next = fast;
        if(slow != null)
            node.next = slow;
    }
}
