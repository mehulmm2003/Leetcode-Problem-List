/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = length(headA);
        int lenB = length(headB);
        int diff = lenA - lenB;
        if (diff > 0) {
            while (headA != null && diff != 0) {
                headA = headA.next;
                diff--;
            }
            if (headA == null) {
                return null;
            }
        } else {
            while (headB != null && diff != 0) {
                headB = headB.next;
                diff++;

            }
            if (headB == null) {
                return null;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }

            headA = headA.next;
            headB = headB.next;

        }
        return null;

    }

    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;

    }
}