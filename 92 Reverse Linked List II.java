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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode M = head, pre = fake;
        int i = 1;
        
        while(M != null && i < m){
            pre = M;
            M = M.next;
            i++;
        }
        
        ListNode N = M;
        while(N != null && i < n){
            N = N.next;
            i++;
        }
        
        ListNode next = N.next;
        N.next = null;
        ListNode last = M;
        M = M.next;
        pre.next.next = null;
        while(M != null){
            ListNode tmp = M.next;
            M.next = pre.next;
            pre.next = M;
            M = tmp;
        }
        last.next = next;
        return fake.next;
    }
}
