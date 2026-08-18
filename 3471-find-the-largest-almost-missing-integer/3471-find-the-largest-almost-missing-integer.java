import java.util.*;

class Solution {
    public int largestInteger(int[] nums, int k) {

        int n = nums.length;

        // Case 1: k == n
        // There is only one subarray, so every element
        // appears in exactly one subarray.
        if (k == n) {
            int ans = -1;

            for (int num : nums) {
                ans = Math.max(ans, num);
            }

            return ans;
        }

        // Count frequency of every number
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Case 2: k == 1
        // Every subarray contains only one element.
        // Therefore, an element is almost missing if
        // it occurs exactly once in the entire array.
        if (k == 1) {
            int ans = -1;

            for (int num : nums) {
                if (freq.get(num) == 1) {
                    ans = Math.max(ans, num);
                }
            }

            return ans;
        }

        // Case 3: 1 < k < n
        // Only the first and last elements can belong
        // to exactly one window.
        int ans = -1;

        if (freq.get(nums[0]) == 1) {
            ans = Math.max(ans, nums[0]);
        }

        if (freq.get(nums[n - 1]) == 1) {
            ans = Math.max(ans, nums[n - 1]);
        }

        return ans;
    }
}