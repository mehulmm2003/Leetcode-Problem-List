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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode odd = head;
        ListNode store = head.next;
        ListNode even = head.next;
        boolean flag = true;
        while (odd.next != null && even.next != null) {
            if (flag) {
                odd.next = odd.next.next;
                odd = odd.next;
            } else {
                even.next = even.next.next;
                even = even.next;
            }

            flag = !flag;
        }
        even.next = null;

        odd.next = store;
        return head;
    }
}