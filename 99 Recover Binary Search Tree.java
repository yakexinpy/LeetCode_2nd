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
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        List<TreeNode> wrong = new ArrayList<TreeNode>();
        pre = null;
        helper(wrong, root);
        
        if(wrong.size() < 1) return;
        TreeNode t1 = wrong.get(0);
        TreeNode t2 = wrong.get(wrong.size() - 1);
        int tmp = t1.val;
        t1.val = t2.val;
        t2.val = tmp;
    }
    
    private void helper(List<TreeNode> wrong, TreeNode root){
        if(root == null) return;
        helper(wrong, root.left);
        
        if(pre != null){
            if(pre.val > root.val){
                wrong.add(pre);
                wrong.add(root);
            }
        }
        pre = root;
        helper(wrong, root.right);
    }
}
