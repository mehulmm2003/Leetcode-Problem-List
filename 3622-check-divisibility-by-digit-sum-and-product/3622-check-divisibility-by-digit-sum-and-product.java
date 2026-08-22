class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0;
        int pro = 1;
        int ncopy = n;
        while (n > 0) {
            sum += n % 10;
            pro *= n % 10;
            n /= 10;
        }
        if (ncopy % (sum + pro) == 0) {
            return true;
        } else {
            return false;
        }

    }
}