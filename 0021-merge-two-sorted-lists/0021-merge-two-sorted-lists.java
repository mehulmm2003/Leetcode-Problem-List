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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        while (list1 != null || list2 != null) {
            int val1 = list1 != null ? list1.val : Integer.MAX_VALUE;
            int val2 = list2 != null ? list2.val : Integer.MAX_VALUE;
            if (val1 < val2) {
                dummy.next = list1;
                dummy = list1;
                if (list1 != null) {
                    list1 = list1.next;
                }
            } else {
                dummy.next = list2;
                dummy = list2;
                if (list2 != null) {
                    list2 = list2.next;
                }
            }
        }
        return ans.next;

    }
}