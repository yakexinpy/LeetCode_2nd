/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) return;
        Queue<TreeLinkNode> Q = new LinkedList<TreeLinkNode>();
        Q.offer(root);
        int curLev = 1, nextLev = 0;
        
        while(!Q.isEmpty()){
            TreeLinkNode node = Q.poll();
            curLev--;
            if(node.left != null){
                Q.offer(node.left);
                nextLev++;
            }
            if(node.right != null){
                Q.offer(node.right);
                nextLev++;
            }
            
            if(curLev == 0){
                node.next = null;
                curLev = nextLev;
                nextLev = 0;
            }
            else{
                node.next = (Q.isEmpty()) ? null : Q.peek();    
            }
        }
    }
}
