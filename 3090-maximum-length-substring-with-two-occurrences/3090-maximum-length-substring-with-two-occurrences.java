class Solution {
    public int maximumLengthSubstring(String s) {
        int count = 0;

        for (int j = 0; j < s.length(); j++) {
            int tempCount = 0;
            int arr[] = new int[26];

            for (int i = j; i < s.length(); i++) {

                char ch = s.charAt(i);
                int idx = (int) ch - 'a';

                if (arr[idx] < 2) {
                    arr[idx]++;
                    tempCount++;
                } else {

                    break;
                }
            }
            if (count < tempCount) {
                count = tempCount;
            }

        }

        return count;

    }
}