class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];
        for (int s : stones) {
            cnt[s % 3]++;
        }
        
        if (cnt[0] % 2 == 0) {
            // cnt0 doesn't flip turn parity at the critical moment
            return cnt[1] >= 1 && cnt[2] >= 1;
        } else {
            // odd cnt0 flips who ends up forced into the losing move
            return Math.abs(cnt[1] - cnt[2]) >= 3;
        }
    }
}