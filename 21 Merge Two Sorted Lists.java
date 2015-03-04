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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode fakeHead = new ListNode(-1);
        ListNode H = fakeHead;
        
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                H.next = l1;
                l1 = l1.next;
            }
            else{
                H.next = l2;
                l2 = l2.next;
            }
            H = H.next;
        }
        
        if(l1 != null)
            H.next = l1;
        if(l2 != null)
            H.next = l2;
        
        return fakeHead.next;
    }
}
