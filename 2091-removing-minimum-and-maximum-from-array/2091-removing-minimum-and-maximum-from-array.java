class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] < nums[minIdx]) minIdx = i;
            if (nums[i] > nums[maxIdx]) maxIdx = i;
        }

        int i = Math.min(minIdx, maxIdx); // earlier occurring extreme
        int j = Math.max(minIdx, maxIdx); // later occurring extreme

        int frontOnly = j + 1;
        int backOnly  = n - i;
        int split     = (i + 1) + (n - j);

        return Math.min(frontOnly, Math.min(backOnly, split));
    }
}