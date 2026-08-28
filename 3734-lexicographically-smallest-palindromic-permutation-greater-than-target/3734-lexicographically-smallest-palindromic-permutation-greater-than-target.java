class Solution {

    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int halfLen = n / 2;

        // Frequency of characters
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // A palindrome can have at most one odd frequency
        int odd = 0;
        char middle = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] % 2 == 1) {
                odd++;
                middle = (char) ('a' + i);
            }
        }

        if (odd > 1) {
            return "";
        }

        // Frequency available for the first half
        int[] half = new int[26];

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
        }

        /*
         * First try to make the first half exactly equal
         * to target's first half.
         *
         * If possible, the resulting palindrome might already
         * be greater than target because of the middle/right side.
         */

        int[] remaining = half.clone();
        boolean possible = true;

        for (int i = 0; i < halfLen; i++) {

            int c = target.charAt(i) - 'a';

            if (remaining[c] == 0) {
                possible = false;
                break;
            }

            remaining[c]--;
        }

        if (possible) {

            String candidate = buildPalindrome(
                    target.substring(0, halfLen),
                    remaining,
                    middle,
                    n
            );

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }

        /*
         * We could not use the exact first half.
         *
         * Find the RIGHTMOST position where we can make
         * the palindrome greater than target.
         *
         * Why rightmost?
         *
         * Example:
         *
         * target = abcdef
         *
         * Changing position 4:
         * abcdf...
         *
         * is smaller than changing position 2:
         * abd...
         *
         * because matching the target for as long as possible
         * gives the lexicographically smallest answer.
         */

        for (int i = halfLen - 1; i >= 0; i--) {

            // Rebuild remaining frequencies after matching
            // target[0 ... i-1]
            remaining = half.clone();

            boolean ok = true;

            for (int j = 0; j < i; j++) {

                int c = target.charAt(j) - 'a';

                if (remaining[c] == 0) {
                    ok = false;
                    break;
                }

                remaining[c]--;
            }

            if (!ok) {
                continue;
            }

            // At position i, choose the smallest character
            // strictly greater than target[i]
            int targetChar = target.charAt(i) - 'a';

            for (int c = targetChar + 1; c < 26; c++) {

                if (remaining[c] > 0) {

                    remaining[c]--;

                    StringBuilder firstHalf = new StringBuilder();

                    // Target prefix
                    firstHalf.append(target.substring(0, i));

                    // Character that makes us greater
                    firstHalf.append((char) ('a' + c));

                    String candidate = buildPalindrome(
                            firstHalf.toString(),
                            remaining,
                            middle,
                            n
                    );

                    return candidate;
                }
            }
        }

        return "";
    }


    private String buildPalindrome(
            String prefix,
            int[] remaining,
            char middle,
            int n) {

        StringBuilder half = new StringBuilder();

        half.append(prefix);

        // Put remaining characters in sorted order
        for (int c = 0; c < 26; c++) {

            for (int count = 0; count < remaining[c]; count++) {
                half.append((char) ('a' + c));
            }
        }

        StringBuilder ans = new StringBuilder();

        // Left half
        ans.append(half);

        // Middle
        if (n % 2 == 1) {
            ans.append(middle);
        }

        // Right half
        for (int i = half.length() - 1; i >= 0; i--) {
            ans.append(half.charAt(i));
        }

        return ans.toString();
    }
}