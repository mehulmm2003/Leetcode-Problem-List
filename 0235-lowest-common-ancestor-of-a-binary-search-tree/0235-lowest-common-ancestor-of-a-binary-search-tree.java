/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val>p.val &&root.val<q.val)
        {
            return root;
        }
        else if(root.val<p.val&&root.val<q.val){
            TreeNode right=lowestCommonAncestor(root.right,p,q);
        return right;}
        else if(root.val>p.val&&root.val>q.val){
           TreeNode left=  lowestCommonAncestor(root.left,p,q);
           return left;
           
        }
        return root;
    }
}