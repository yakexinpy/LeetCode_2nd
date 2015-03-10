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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int k = n;
        ListNode H = head;
        
        while(H != null && k != 0){
            k--;
            H = H.next;
        }
        if(H == null) return head.next;
        
        ListNode node = head;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode pre = fake;
        
        while(H != null){
            H = H.next;
            pre = node;
            node = node.next;
        }
        
        pre.next = node.next;
        return fake.next;
    }
}
