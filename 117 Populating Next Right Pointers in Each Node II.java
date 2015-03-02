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
        
        if(root.left != null){
            if(root.right != null) root.left.next = root.right;
            else{
                TreeLinkNode rightRoot = root.next;
                if(rightRoot == null) root.left.next = null;
                else{
                    while(root.left.next == null && rightRoot != null){
                        if(rightRoot.left != null) root.left.next = rightRoot.left;
                        else if(rightRoot.right != null) root.left.next = rightRoot.right;
                        else root.left.next = null;
                        rightRoot = rightRoot.next;
                    }
                }
            }
        }
        
        if(root.right != null){
            TreeLinkNode rightRoot = root.next;
            if(rightRoot == null) root.right.next = null;
            else{
                while(root.right.next == null && rightRoot != null){
                    if(rightRoot.left != null) root.right.next = rightRoot.left;
                    else if(rightRoot.right != null) root.right.next = rightRoot.right;
                    else root.right.next = null;
                    rightRoot = rightRoot.next;
                }
            }
        }
        
        connect(root.right);
        connect(root.left);
    }
}
