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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> main = new ArrayDeque<>();
        Queue<TreeNode> helper = new ArrayDeque<>();
        if(root==null){
            return ans;
        }
        main.add(root);
        while(main.size()>0){
            if(main.size()==1){
                ans.add(main.element().val);
            }
            TreeNode node=main.remove();
            if(node.left!=null){
                helper.add(node.left);
            }
            if(node.right!=null){
                helper.add(node.right);

            }
            if(main.size()==0){
                main=helper;
                helper=new ArrayDeque<>();

            }
        }
        return ans;


    }
}