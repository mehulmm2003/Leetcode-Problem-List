class Solution {
    public int maxProduct(int n) {
        int size = size(n);
        int arr[] = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            arr[i] = n % 10;
            n = n / 10;
        }
        int max = -1;
        for (int i = 0; i < size-1; i++) {
            int st = i;
            int end = i+1;
            while (end < size) {
                max = Math.max(max, arr[st] * arr[end]);
                end++;
            }
        }
        return max;

    }

    public int size(int n) {
        int count = 0;
        while (n > 0) {
            count++;
            n = n / 10;
        }
        return count;
    }
}