import java.util.*;

class Solution {

    static class State {
        long weight;
        int[] indices;

        State(long weight, int[] indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        // [start, end, weight, originalIndex]
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }

        // Sort by start
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        /*
         * next[i] = first interval whose start > arr[i][1]
         */
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            next[i] = upperBound(arr, arr[i][1], i + 1);
        }

        /*
         * dp[i][k]:
         * Best result using intervals from i onward,
         * where we can still choose at most k intervals.
         */
        State[][] dp = new State[n + 1][5];

        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new int[0]);
        }

        for (int i = n - 1; i >= 0; i--) {

            dp[i][0] = new State(0, new int[0]);

            for (int k = 1; k <= 4; k++) {

                // Option 1: Don't take current interval
                State skip = dp[i + 1][k];

                // Option 2: Take current interval
                State nextState = dp[next[i]][k - 1];

                int[] selected =
                    new int[nextState.indices.length + 1];

                selected[0] = arr[i][3];

                for (int j = 0; j < nextState.indices.length; j++) {
                    selected[j + 1] = nextState.indices[j];
                }

                // Required for lexicographical comparison
                Arrays.sort(selected);

                long takeWeight =
                    (long) arr[i][2] + nextState.weight;

                State take =
                    new State(takeWeight, selected);

                // Choose the better option
                if (take.weight > skip.weight) {
                    dp[i][k] = take;
                }
                else if (take.weight < skip.weight) {
                    dp[i][k] = skip;
                }
                else {
                    // Same weight -> lexicographically smaller indices
                    if (compare(take.indices, skip.indices) < 0) {
                        dp[i][k] = take;
                    }
                    else {
                        dp[i][k] = skip;
                    }
                }
            }
        }

        return dp[0][4].indices;
    }

    /*
     * Find first index j such that:
     *
     * arr[j][0] > end
     *
     * because intervals sharing a boundary are considered overlapping.
     */
    private int upperBound(int[][] arr, int end, int left) {

        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid][0] <= end) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        return left;
    }

    /*
     * Lexicographical comparison of two arrays.
     */
    private int compare(int[] a, int[] b) {

        int n = Math.min(a.length, b.length);

        for (int i = 0; i < n; i++) {

            if (a[i] != b[i]) {
                return Integer.compare(a[i], b[i]);
            }
        }

        return Integer.compare(a.length, b.length);
    }
}