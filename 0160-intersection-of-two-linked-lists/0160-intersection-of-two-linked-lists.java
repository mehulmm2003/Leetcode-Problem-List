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
    public int length(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int length1=length(headA);
        int length2=length(headB);
        int diff=length1-length2;
        if(diff<0){
            while(diff!=0){
                headB=headB.next;
                diff++;
            }

        }
        else{
            while(diff!=0){
                headA=headA.next;
                diff--;

            }

        }


        while(headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA=headA.next;
            headB=headB.next;

        }
        return null;

        
    }
}