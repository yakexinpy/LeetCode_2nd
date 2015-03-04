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
    public ListNode rotateRight(ListNode head, int n) {
        if(head == null || head.next == null || n == 0) return head;
        
        int size = 1;
        ListNode H = head;
        while(H.next != null){
            size++;
            H = H.next;
        }
        n = n % size;
        
        ListNode h = head;
        int res = 1;
        while(res + n< size){
            h = h.next;
            res++;
        }
        
        H.next = head;
        head = h.next;
        h.next = null;
        return head;
    }
}
