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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return helper(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }
    
    private boolean helper(TreeNode root, int max, int min){
        if(root == null) return true;
        if(root.val < min || root.val > max) return false;
        
        if(root.val == Integer.MIN_VALUE && root.left != null) return false;
        if(root.val == Integer.MAX_VALUE && root.right != null) return false;
        
        return helper(root.left, root.val - 1, min) && helper(root.right, max, root.val + 1);
    }
}
