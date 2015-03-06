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
    public ListNode partition(ListNode head, int x) {
        ListNode fake = new ListNode(-1);
        ListNode mid = new ListNode(x);
        ListNode F = fake, M = mid;
        
        while(head != null){
            if(head.val < x){
                F.next = head;
                F = F.next;
            }
            else{
                M.next = head;
                M = M.next;
            }
            head = head.next;
        }
        
        F.next = mid.next;
        M.next = null;
        
        return fake.next;
    }
}
