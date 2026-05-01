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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode store = null;
        ListNode dummy = null;
        int carry = 0;

        while (l1 != null || l2 != null||carry!=0) {
            int ele1 = l1 != null ? l1.val : 0;
            int ele2 = l2 != null ? l2.val : 0;
            int sum = ele1 + ele2 + carry;
            ListNode n = new ListNode(sum % 10);
            if (dummy == null) {
                store = n;
                dummy = n;
            } else {
                dummy.next = n;
                dummy = n;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;

            }
        }
      

        return store;

    }
}