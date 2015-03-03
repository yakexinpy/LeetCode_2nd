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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if(root == null) return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        
        TreeNode node = root;
        TreeNode last = null;
        
        while(!stack.isEmpty()){
            while(node != null && node.left != null){
                node = node.left;
                stack.push(node);
            }
            
            node = stack.peek();
            if(node.right != null && node.right != last){
                node = node.right;
                stack.push(node);
            }
            else{
                ret.add(node.val);
                last = stack.pop();
                node = null;
            }
        }
        return ret;
    }
}
