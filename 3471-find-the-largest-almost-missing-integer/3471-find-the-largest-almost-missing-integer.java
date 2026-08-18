class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> distinct = new HashSet<>();
        for (int v : nums) distinct.add(v);
        
        int ans = -1;
        for (int x : distinct) {
            int count = 0;
            for (int i = 0; i <= n - k; i++) {
                boolean found = false;
                for (int j = i; j < i + k; j++) {
                    if (nums[j] == x) {
                        found = true;
                        break;
                    }
                }
                if (found) count++;
                if (count > 1) break; // early exit
            }
            if (count == 1) {
                ans = Math.max(ans, x);
            }
        }
        return ans;
    }
}