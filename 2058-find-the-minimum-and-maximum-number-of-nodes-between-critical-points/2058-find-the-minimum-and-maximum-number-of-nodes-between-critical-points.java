class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prevCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        int position = 1;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode next = curr.next;

        while (next != null) {

            // Check if curr is a critical point
            if ((curr.val > prev.val && curr.val > next.val) ||
                (curr.val < prev.val && curr.val < next.val)) {

                // First critical point
                if (first == -1) {
                    first = position;
                }

                // Distance from previous critical point
                if (prevCritical != -1) {
                    minDistance = Math.min(
                        minDistance,
                        position - prevCritical
                    );
                }

                prevCritical = position;
            }

            prev = curr;
            curr = next;
            next = next.next;
            position++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == prevCritical) {
            return new int[]{-1, -1};
        }

        maxDistance = prevCritical - first;

        return new int[]{minDistance, maxDistance};
    }
}