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
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root){
        int ret = helper(root);
        return Math.max(ret, max);
    }
    
    public int helper(TreeNode root) {
        if(root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        
        int sum = root.val + ((left < 0) ? 0 : left) + ((right < 0) ? 0 : right);
        left += root.val;
        right += root.val;
        max = Math.max(max, sum);
        return Math.max(Math.max(left, right), root.val);
    }
}
