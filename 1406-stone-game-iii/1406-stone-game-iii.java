class Solution {
    Integer[] dp;

    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        dp = new Integer[n];

        int diff = helper(stoneValue, 0);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    private int helper(int[] stoneValue, int index) {
        int n = stoneValue.length;

       
        if (index >= n) {
            return 0;
        }

       
        if (dp[index] != null) {
            return dp[index];
        }

        int sum = 0;
        int best = Integer.MIN_VALUE;

        
        for (int k = 0; k < 3 && index + k < n; k++) {
            sum += stoneValue[index + k];
            best = Math.max(best, sum - helper(stoneValue, index + k + 1));
        }

        return dp[index] = best;
    }
}