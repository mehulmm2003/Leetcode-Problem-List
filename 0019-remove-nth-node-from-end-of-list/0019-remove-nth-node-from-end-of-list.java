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
    public int length(ListNode head){
        int count=0;

        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len=length(head);
        if(len==1){
            ListNode ans=null;
            return ans;
        }
        int target=len-n;
        if(target==0){
            return head.next;
        }
        ListNode dummy=head;
        while(target>1){
            target--;
            dummy=dummy.next;

        }
        
        dummy.next=dummy.next.next;
        
        return head;
    }
}