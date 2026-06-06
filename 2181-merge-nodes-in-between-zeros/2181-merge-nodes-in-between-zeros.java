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
class Solution {
    public ListNode mergeNodes(ListNode head) {
        int sum=0;
        ListNode root = head.next;
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;

        while (root != null) {
            if (root.val == 0) {
                if (sum != 0) {
                    ListNode n = new ListNode(sum);
                    dummy.next = n;
                    dummy = n;

                    sum = 0;
                }
            } else {
                sum += root.val;
                
            }
            root = root.next;
        }
        return ans.next;
    }
}