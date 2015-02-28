/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        
        return helper(1, n);
    }
    
    private List<TreeNode> helper(int start, int end){
        List<TreeNode> ret = new ArrayList<TreeNode>();
        if(start > end){
            ret.add(null);
            return ret;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> lefts = helper(start, i - 1);
            List<TreeNode> rights = helper(i + 1, end);
            
            for(TreeNode left : lefts){
                for(TreeNode right : rights){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        return ret;
    }
}
