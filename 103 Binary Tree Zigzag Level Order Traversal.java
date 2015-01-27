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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root != null) 
            q.add(root);
        
        boolean reverse = false;
        List<Integer> temp = new ArrayList<Integer>();
        
        int curLev = 1, nextLev = 0;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            curLev--;
            
            if(node.left != null){
                q.add(node.left);
                nextLev++;
            }
            if(node.right != null){
                q.add(node.right);
                nextLev++;
            }
            
            if(reverse)
                temp.add(0, node.val);
            else
                temp.add(node.val);
            
            if(curLev == 0){
                ret.add(new ArrayList<Integer>(temp));
                temp.clear();
                curLev = nextLev;
                nextLev = 0;
                reverse = reverse ? false : true;
            }
        }
        return ret;
    }
}
