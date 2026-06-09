class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int row = 0; row < m; row++) {
            if (matrix[row][n - 1] >= target) {
                n -= 1;
                while (n >= 0) {

                    if (matrix[row][n] == target) {
                        return true;
                    }
                    n--;
                }
                return false;

            }
        }
        return false;

    }
}