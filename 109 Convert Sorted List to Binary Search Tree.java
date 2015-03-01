/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    ListNode H;
    public TreeNode sortedListToBST(ListNode head) {
        H = head;
        ListNode h = head;
        int len = 0;
        while(h != null){
            len++;
            h = h.next;
        }
        return helper(0, len - 1);
    }
    
    private TreeNode helper(int start, int end){
        if(start > end) return null;
        int mid = (start + end) / 2;
        TreeNode left = helper(start, mid - 1);
        TreeNode root = new TreeNode(H.val);
        H = H.next;
        TreeNode right = helper(mid + 1, end);
        root.left = left;
        root.right = right;
        return root;
    }
}
