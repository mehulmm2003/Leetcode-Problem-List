class Solution {
    public int[][] generateMatrix(int n) {
        int mat[][] = new int[n][n];
        int num = 1;
        int rst = 0;
        int cst = 0;
        int rend = n - 1;
        int cend = n - 1;
        int r = 0;
        int c = 0;

        while (num <= n * n) {
            while (c <= cend) {
                mat[r][c] = num;
                num++;
                c++;
            }
            c--;
            r++;
            rst++;
            while (r <= rend) {
                mat[r][c] = num;
                num++;
                r++;
            }
            r--;
            c--;
            cend--;

            while (c >= cst) {
                mat[r][c] = num;
                num++;
                c--;

            }
            c++;
            r--;
            rend--;
            while (r >= rst) {
                mat[r][c] = num;
                num++;
                r--;
            }
            r++;
            c++;
            cst++;

        }
        return mat;

    }
}