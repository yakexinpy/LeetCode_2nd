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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode t = root;
        
        while(t != null || !stack.isEmpty()){
            if(t.right != null)
                stack.push(t.right);
            if(t.left != null){
                t.right = t.left;
                t.left = null;
            }
            else{
                if(!stack.isEmpty())
                    t.right = stack.pop();
            }
            t = t.right;
        }
    }
}
