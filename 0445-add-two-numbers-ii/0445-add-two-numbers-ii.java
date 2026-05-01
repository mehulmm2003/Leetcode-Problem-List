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
// class Solution {
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
//     }
// }



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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode num1 = reverse(l1);
        ListNode num2 = reverse(l2);
        ListNode dummy = null;
        int carry = 0;

        while (num1 != null || num2 != null) {
            int ele1 = num1 != null ? num1.val : 0;
            int ele2 = num2 != null ? num2.val : 0;
            int sum = ele1 + ele2 + carry;
            ListNode n = new ListNode(sum % 10);
            if (dummy == null) {
                dummy = n;
            } else {
                n.next=dummy;
                dummy = n;
            }
            carry = sum / 10;
            if (num1 != null) {
                num1 = num1.next;
            }
            if (num2 != null) {
                num2 = num2.next;

            }
        }
        if (carry != 0) {
            ListNode n = new ListNode(carry);
            if (dummy == null) {
                dummy = n;
            } else {
                n.next = dummy;
                dummy = n;
            }

        }


        return dummy;

    }
}