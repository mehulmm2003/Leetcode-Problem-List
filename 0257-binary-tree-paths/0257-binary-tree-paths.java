/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, new StringBuilder(), result);
        return result;
    }
    
    private void dfs(TreeNode node, StringBuilder path, List<String> result) {
        int len = path.length();
        
        if (len > 0) path.append("->");
        path.append(node.val);
        
        if (node.left == null && node.right == null) {
            result.add(path.toString());
        } else {
            if (node.left != null) dfs(node.left, path, result);
            if (node.right != null) dfs(node.right, path, result);
        }
        
        // backtrack: restore StringBuilder to its state before this call
        path.setLength(len);
    }
}