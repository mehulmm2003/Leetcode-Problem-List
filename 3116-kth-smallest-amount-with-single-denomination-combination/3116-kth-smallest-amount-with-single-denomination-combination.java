import java.util.*;

class Solution {

    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;

        long low = 1;
        long high = (long) coins[0] * k;

        // Find minimum coin for tighter upper bound
        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(mid, coins) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(long x, int[] coins) {
        int n = coins.length;
        long result = 0;

        // Iterate through all non-empty subsets
        for (int mask = 1; mask < (1 << n); mask++) {

            long lcm = 1;
            int bits = 0;
            boolean valid = true;

            for (int i = 0; i < n; i++) {

                if ((mask & (1 << i)) != 0) {
                    bits++;

                    lcm = getLCM(lcm, coins[i]);

                    // LCM is already greater than x
                    if (lcm > x) {
                        valid = false;
                        break;
                    }
                }
            }

            if (!valid) {
                continue;
            }

            long contribution = x / lcm;

            // Odd number of elements -> add
            if ((bits & 1) == 1) {
                result += contribution;
            }
            // Even number of elements -> subtract
            else {
                result -= contribution;
            }
        }

        return result;
    }

    private long getLCM(long a, long b) {
        return (a / gcd(a, b)) * b;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}