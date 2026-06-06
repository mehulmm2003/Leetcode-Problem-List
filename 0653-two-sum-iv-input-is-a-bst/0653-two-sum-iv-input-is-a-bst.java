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
    public void traversal(TreeNode root, ArrayList<Integer> arr) {
        if (root == null) {
            return;
        }
        traversal(root.left, arr);
        arr.add(root.val);
        traversal(root.right, arr);
        return;

    }

    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer>arr=new ArrayList<>();
        traversal(root,arr);
        int st=0;
        int end=arr.size()-1;
        while(st<end){
            if(arr.get(st)+arr.get(end)==k){
                return true;
            }
            else if(arr.get(st)+arr.get(end)<k){
                st++;
            }
            else{
                end--;
            }
        }
        return false;
        
    }
}