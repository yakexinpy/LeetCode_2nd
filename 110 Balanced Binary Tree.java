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
    public boolean isBalanced(TreeNode root) {
        return helper(root) >= 0;
    }
    
    private int helper(TreeNode node){
        if(node == null) return 0;
        
        int left = helper(node.left);
        int right = helper(node.right);
        
        if(left < 0 || right < 0) return -1;
        if(Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
