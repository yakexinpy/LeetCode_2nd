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
        
        ListNode fake = new ListNode(-1);
        ListNode last = head, H = fake;
        head = head.next;
        boolean dup = false;
        
        while(head != null){
            if(head.val == last.val){
                dup = true;
            }
            else{
                if(dup){
                    last = head;
                    dup = false;
                }
                else{
                    H.next = last;
                    H = H.next;
                    last = head;
                }
            }
            head = head.next;
        }
        
        if(!dup){
            H.next = last;
            H= H.next;
        }
        H.next = null;
        return fake.next;
    }
}
