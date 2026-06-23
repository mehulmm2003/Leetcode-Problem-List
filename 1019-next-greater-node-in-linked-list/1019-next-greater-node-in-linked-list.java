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
    public int size(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }

    public int[] nextLargerNodes(ListNode head) {
        int size = size(head);
        int arr[] = new int[size];
        ListNode nhead = head;
        int store[] = new int[size];
        int idx = 0;
        while (nhead != null) {

            store[idx] = nhead.val;
            nhead = nhead.next;
            idx++;
        }
        arr[size - 1] = 0;
        if (size == 1) {
            return arr;
        }
        Stack<Integer> st = new Stack<>();
        st.push(store[size - 1]);
        for (int i = size - 2; i >= 0; i--) {
            if (st.size() > 0 && st.peek() > store[i]) {
                arr[i] = st.peek();
                st.push(store[i]);

            } else if (st.size() > 0 && st.peek() <= store[i]) {
                while (st.size() > 0 && st.peek() <= store[i]) {
                    st.pop();
                }
                if (st.size() == 0) {
                    arr[i] = 0;

                } else {
                    arr[i] = st.peek();
                }
                st.push(store[i]);
            } else {
                arr[i] = 0;
                st.push(store[i]);
            }

        }

        return arr;
    }
}