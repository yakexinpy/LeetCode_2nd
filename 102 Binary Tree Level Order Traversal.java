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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(root == null) return ret;
        List<Integer> tmp = new ArrayList<Integer>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        int curLev = 1, nextLev = 0;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            curLev--;
            tmp.add(node.val);
            
            if(node.left != null){
                q.add(node.left);
                nextLev++;
            }
            if(node.right != null){
                q.add(node.right);
                nextLev++;
            }
            
            if(curLev == 0){
                curLev = nextLev;
                nextLev = 0;
                ret.add(new ArrayList<Integer>(tmp));
                tmp.clear();
            }
        }
        return ret;
    }
}
