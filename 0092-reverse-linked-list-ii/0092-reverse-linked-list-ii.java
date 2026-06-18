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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right){
            return head;
        }
        ListNode pre = head;
        ListNode front = head;
        ListNode end = head;
        while (left > 1 || right > 1) {
            if (left > 1 && right > 1) {
                pre=front;
                front = front.next;
                end = end.next;
                left--;
                right--;

            } else {
                end = end.next;
                right--;
            }
        }

        ListNode rev = reverse(front, end);
        if (front == head) {
            return rev;
        } else {
            pre.next = rev;
            return head;

        }

    }
    public ListNode reverse(ListNode front,ListNode end){
       ListNode stop=end.next;
        ListNode pre=end.next;
        ListNode curr=front;
        while(curr!=stop){
            ListNode nbr=curr.next;
            curr.next=pre;
            pre=curr;
            curr=nbr;


        }
        return pre;
    }
}