class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        int xor = 0;
        boolean hasNonZero = false;

        for (int num : nums) {
            xor ^= num;

            if (num != 0) {
                hasNonZero = true;
            }
        }

        // Case 1
        if (xor != 0) {
            return n;
        }

        // Case 2
        if (hasNonZero) {
            return n - 1;
        }

        // Case 3
        return 0;
    }
}