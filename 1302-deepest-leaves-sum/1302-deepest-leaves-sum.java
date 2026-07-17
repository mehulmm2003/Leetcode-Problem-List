/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int sum=0;
    public int deepestLeavesSum(TreeNode root) {
        int depth=maxdepth(root);
        finder(root,depth);
        return sum;
        

    }
    public void finder(TreeNode root,int depth){
        if(depth==1 ){
            if(root!=null){
            sum+=root.val;}
            
            return;

        }
        if(root==null){
            return;
        }
        finder(root.left,depth-1);
        finder(root.right,depth-1);
        return;
    }

    public int maxdepth(TreeNode root) {
        if (root == null) {
            return 0;

        }
        int left = maxdepth(root.left);
        int right = maxdepth(root.right);
        return Math.max(left,right)+1;

    }
}