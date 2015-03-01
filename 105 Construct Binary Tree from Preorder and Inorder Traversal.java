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
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length) return null;
        index = 0;
        return helper(0, inorder.length - 1, preorder, inorder);
    }
    
    private TreeNode helper(int start, int end, int[] pre, int[] in){
        if(index > pre.length || start > end){ 
            index--;
            return null;
        }

        int mid = 0;
        int i = 0;
        while(i < in.length && in[i] != pre[index])
            i++;
        mid = i;
        
        TreeNode root = new TreeNode(pre[index]);
        index++;
        TreeNode l = helper(start, mid - 1, pre, in);
        index++;
        TreeNode r = helper(mid + 1, end, pre, in);
        root.left = l;
        root.right = r;
        return root;
        
    }
}
