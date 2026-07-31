class Solution {
    public int minimumPushes(String word) {
        int freq[] = new int[26];
        for (char ch : word.toCharArray()) {
            freq[ch - 'a'] += 1;

        }
        Arrays.sort(freq);
        int j = 25;
        for (int i = 0; i < 13; i++, j--) {
            int temp = freq[j];
            freq[j] = freq[i];
            freq[i] = temp;
        }

        int total = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) {
                break;
            }
            int cost = (i / 8) + 1;
            total += cost * freq[i];
        }
        return total;
    }
}