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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Stack<Integer> curSum = new Stack<Integer>();
        
        stack.push(root);
        curSum.push(0);
        int sum = 0, cur = 0;
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            cur = curSum.pop();
            cur = cur * 10 + node.val;
            
            if(node.right == null && node.left == null){
                sum += cur;
                continue;
            }
            
            if(node.right != null){
                stack.push(node.right);
                curSum.push(cur);
            }
            
            if(node.left != null){
                stack.push(node.left);
                curSum.push(cur);
            }
        }
        return sum;
    }
}
