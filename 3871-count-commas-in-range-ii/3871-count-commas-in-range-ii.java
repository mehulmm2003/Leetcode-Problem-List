class Solution {
    public long countCommas(long n) {

        long ans = 0;
        long power = 1000;
        long commas = 1;

        while (power <= n) {

            long next = power * 1000;

            if (next > n) {
                ans += (n - power + 1) * commas;
                break;
            }

            ans += (next - power) * commas;

            power = next;
            commas++;
        }

        return ans;
    }
}