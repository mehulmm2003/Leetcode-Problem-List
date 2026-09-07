class Solution {
    public int distinctSubseqII(String s) {
        final int MOD = 1_000_000_007;
        long[] last = new long[26];   // last[c] = dp value right before last occurrence of c
        long dp = 1;                  // dp includes the empty subsequence

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            long newDp = (2 * dp % MOD - last[idx] + MOD) % MOD;
            last[idx] = dp;           // save dp BEFORE updating it
            dp = newDp;
        }

        // subtract the empty subsequence, ensure non-negative
        return (int) ((dp - 1 + MOD) % MOD);
    }
}