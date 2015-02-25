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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode fake = new ListNode(-1);
        ListNode head = fake;
        
        int carry = 0, sum = 0;
        while(l1 != null || l2 != null){
            sum = carry + ((l1 == null) ? 0 : l1.val) + ((l2 == null) ? 0 : l2.val);
            l1 = (l1 == null) ? l1 : l1.next;
            l2 = (l2 == null) ? l2 : l2.next;
            head.next = new ListNode(sum % 10);
            head = head.next;
            carry = sum / 10;
        }
        if(carry > 0)
            head.next = new ListNode(carry);
        return fake.next;
    }
}
