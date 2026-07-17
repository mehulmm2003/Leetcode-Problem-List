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
    public TreeNode balanceBST(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        TreeNode result = helper(ans, 0, ans.size() - 1);
        return result;

    }

    public TreeNode helper(ArrayList<Integer> ans, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        TreeNode result = new TreeNode(ans.get(mid));
        result.left = helper(ans, st, mid - 1);
        result.right = helper(ans, mid + 1, end);

        return result;
    }

    public void inorder(TreeNode root,ArrayList<Integer> ans){
        if(root==null){
            return ;
        }
        inorder(root.left,ans);
        ans.add(root.val);
        inorder(root.right,ans);

    }
}