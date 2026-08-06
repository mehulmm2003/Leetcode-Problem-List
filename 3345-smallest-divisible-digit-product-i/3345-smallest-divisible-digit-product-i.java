class Solution {
    public int smallestNumber(int n, int t) {
        for (int i = n; i < n + t; i++) {
            int num=findProduct(i);
            if(num%t==0){
                return i;
            }

        }
        return -1;

    }

    public int findProduct(int n) {
        int num = 1;
        while (n > 0) {
            num *= n % 10;
            n = n / 10;

        }
        return num;
    }
}