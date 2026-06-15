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
    public ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nbr = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nbr;
        }
        return pre;
    }

    public ListNode doubleIt(ListNode head) {
        ListNode nhead = reverse(head);
        ListNode dummy = new ListNode(-1);
        ListNode ans = dummy;
        int carry = 0;
        while (nhead != null) {
            int val = nhead.val * 2 + carry;

            ListNode temp = new ListNode(val % 10);
            carry = val / 10;
            dummy.next = temp;
            dummy = temp;
            nhead=nhead.next;

        }
        if (carry > 0) {
            dummy.next = new ListNode(carry);
        }
        ListNode res = reverse(ans.next);
        return res;
    }
}