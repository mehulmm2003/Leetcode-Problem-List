class Solution {
    public boolean uniformArray(int[] nums1) {

        boolean hasOdd = false;
        boolean hasEven = false;

        for (int x : nums1) {
            if (x % 2 == 0) {
                hasEven = true;
            } else {
                hasOdd = true;
            }
        }

        // All elements have the same parity
        if (!hasOdd || !hasEven) {
            return true;
        }

        // Mixed parity: minimum must be odd
        int min = Integer.MAX_VALUE;

        for (int x : nums1) {
            min = Math.min(min, x);
        }

        return min % 2 == 1;
    }
}