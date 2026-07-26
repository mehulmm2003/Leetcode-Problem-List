class Solution {
    public int maximumProduct(int[] nums) {
        int n1 = Integer.MIN_VALUE;
        int n2 = Integer.MIN_VALUE;
        int n3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max = n1 * n2 * n3;

        for (int i = 0; i < nums.length; i++) {
            if (n1 < nums[i]) {
                n3 = n2;
                n2 = n1;
                n1 = nums[i];
            } else if (n2 < nums[i]) {
                n3 = n2;
                n2 = nums[i];
            } else if (n3 < nums[i]) {
                n3 = nums[i];

            }

            if (min1 > nums[i]) {
                min2 = min1;
                min1 = nums[i];
            } else if (min2 > nums[i]) {
                min2 = nums[i];
            }
            max = Math.max(n1 * min1 * min2, n1 * n2 * n3);

        }
        return max;

    }
}