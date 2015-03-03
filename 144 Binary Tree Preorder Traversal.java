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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            ret.add(node.val);
            
            if(node.right != null)
                stack.push(node.right);
            if(node.left != null)
                stack.push(node.left);
        }
        return ret;
    }
}
