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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        helper(ret, tmp, root, sum);
        return ret;
    }
    
    private void helper(List<List<Integer>> ret, List<Integer> tmp, TreeNode root, int sum){
        if(root == null) return;
        if(root.left == null && root.right == null && root.val == sum){
            tmp.add(root.val);
            ret.add(new ArrayList<Integer>(tmp));
            tmp.remove(tmp.size() - 1);
            return;
        }
        if(root.left != null){
            tmp.add(root.val);
            helper(ret, tmp, root.left, sum - root.val);
            tmp.remove(tmp.size() - 1);
        }
        if(root.right != null){
            tmp.add(root.val);
            helper(ret, tmp, root.right, sum - root.val);
            tmp.remove(tmp.size() - 1);
        }
    }
}
