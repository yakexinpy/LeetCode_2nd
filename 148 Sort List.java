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
    public ListNode sortList(ListNode head) {
        if(head == null ||head.next == null) return head;
        ListNode slow = head, fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode left = head, right = slow.next;
        slow.next = null;
        
        ListNode leftHalf = null, rightHalf = null;
        if(left != right){
            leftHalf = sortList(left);
            rightHalf = sortList(right);
        }
        return merge(leftHalf, rightHalf);
    }
    
    private ListNode merge(ListNode left, ListNode right){
        ListNode H = new ListNode(-1);
        ListNode head = H;
        
        while(left != null && right != null){
            if(left.val <= right.val){
                head.next = left;
                left = left.next;
                head = head.next;
            }
            else{
                head.next = right;
                right = right.next;
                head = head.next;
            }
        }
        if(left != null)
            head.next = left;
        if(right != null)
            head.next = right;
    
        return H.next;
    }
}
