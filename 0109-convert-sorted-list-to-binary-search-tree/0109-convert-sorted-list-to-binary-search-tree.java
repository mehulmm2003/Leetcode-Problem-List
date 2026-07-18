/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer>ans=new ArrayList<>();
        listmaker(head,ans);
      TreeNode res=  maker(0,ans.size()-1,ans);
return res;
    }

    public TreeNode maker(int st, int end, ArrayList<Integer> ans) {
        if (st > end) {
            return null;
        }
        int mid = (st + end) / 2;
        TreeNode result = new TreeNode(ans.get(mid));
        result.left = maker(st, mid - 1, ans);
        result.right = maker(mid + 1, end, ans);
        return result;
    }

    public void listmaker(ListNode head, ArrayList<Integer> ans) {
        if (head == null) {
            return;
        }
         ans.add(head.val);
        listmaker(head.next,ans);
       
        
        return;
    }
}