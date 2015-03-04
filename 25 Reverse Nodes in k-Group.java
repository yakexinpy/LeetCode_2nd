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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k < 2) return head;
        ListNode fake = new ListNode(-1);
        fake.next = head;
        
        ListNode H = head;
        int size = 0;
        while(head != null){
            size++;
            head = head.next;
        }
        
        int res = size % k;
        ListNode pre = fake;
        H = pre.next;
        ListNode nextK = pre.next;
        int curLen = 0, count = 0;
        
        while(H != null && count + res <= size){
            if(curLen < k){
                if(pre.next != H){
                    ListNode tmp = H.next;
                    H.next = pre.next;
                    pre.next = H;
                    nextK.next = tmp;
                    H = tmp;
                }
                else
                    H = H.next;
            }
            else{
                curLen = -1;
                count--;
                pre = nextK;
                nextK = pre.next;
                H = pre.next;
            }
            curLen++;
            count++;
        }
        return fake.next;
    }
}
