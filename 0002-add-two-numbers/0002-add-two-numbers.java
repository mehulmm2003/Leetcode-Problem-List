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
        if(l1==null){
            return l2;
        }
        else if(l2==null){
            return l1;
        }
        ListNode one = l1;
        ListNode two = l2;
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode ans=dummy;

        while (one != null || two != null) {
            int ele1 = one != null ? one.val : 0;

            int ele2 = two != null ? two.val : 0;
            if(one!=null){
                one=one.next;
            }
            if(two!=null){
                two=two.next;
            }
            int sum = ele1 + ele2 + carry;
            ListNode temp = new ListNode(sum % 10);
           
            carry = sum / 10;
            dummy.next = temp;
            dummy = temp;

        }
        if(carry!=0){
            dummy.next=new ListNode(carry);
        }
        return ans.next;

    }

}