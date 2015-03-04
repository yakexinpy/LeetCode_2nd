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
    public ListNode swapPairs(ListNode head) {
        ListNode fake = new ListNode(-1);
        ListNode H = fake;
        fake.next = head;
        
        ListNode pre = H;
        while(head != null && head.next != null){
            pre.next = head.next;
            head.next = head.next.next;
            pre.next.next = head;
            pre = head;
            head = head.next;
        }
        
        return fake.next;
    }
}
