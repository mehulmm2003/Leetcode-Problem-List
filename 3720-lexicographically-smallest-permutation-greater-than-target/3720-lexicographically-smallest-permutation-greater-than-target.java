class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();

        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        StringBuilder prefix = new StringBuilder();

        for (int i = 0; i < n; i++) {

            int idx = target.charAt(i) - 'a';

            // Try to keep the same character as target[i]
            if (freq[idx] > 0) {
                freq[idx]--;
                prefix.append(target.charAt(i));
                continue;
            }

            // Cannot match target[i].
            // Try to make the answer greater at this position.
            for (int c = idx + 1; c < 26; c++) {

                if (freq[c] > 0) {
                    prefix.append((char) ('a' + c));
                    freq[c]--;

                    // Put remaining characters in sorted order
                    appendSorted(prefix, freq);

                    return prefix.toString();
                }
            }

            // Cannot increase at this position.
            // Backtrack.
            break;
        }

        /*
         * We matched target for some prefix.
         * Now go backwards and try to increase the prefix.
         */
        for (int i = prefix.length() - 1; i >= 0; i--) {

            char removed = prefix.charAt(i);
            freq[removed - 'a']++;

            prefix.deleteCharAt(i);

            int targetChar = target.charAt(i) - 'a';

            // Find the smallest character greater than target[i]
            for (int c = targetChar + 1; c < 26; c++) {

                if (freq[c] > 0) {
                    prefix.append((char) ('a' + c));
                    freq[c]--;

                    appendSorted(prefix, freq);

                    return prefix.toString();
                }
            }
        }

        return "";
    }

    private void appendSorted(StringBuilder sb, int[] freq) {
        for (int c = 0; c < 26; c++) {
            while (freq[c] > 0) {
                sb.append((char) ('a' + c));
                freq[c]--;
            }
        }
    }
}