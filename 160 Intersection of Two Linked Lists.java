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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode A = headA, B = headB;
        
        while(A != null){
            lenA++;
            A = A.next;
        }
        
        while(B != null){
            lenB++;
            B = B.next;
        }
        
        A = headA;
        B = headB;
        
        while(lenA > lenB){
            A = A.next;
            lenA--;
        }
        
        while(lenB > lenA){
            B = B.next;
            lenB--;
        }
        
        while(A != null && B!= null){
            if(A == B) return A;
            A = A.next;
            B = B.next;
        }
        
        return null;
    }
}
