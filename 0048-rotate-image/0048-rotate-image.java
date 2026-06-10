class Solution {
    public void reverse(int[] arr) {
        int st = 0;
        int end = arr.length - 1;
        while (st < end) {
            int store = arr[st];
            arr[st] = arr[end];
            arr[end] = store;

            st++;
            end--;
        }
    }

    public void rotate(int[][] matrix) {
        int n =matrix.length;
        for(int row=0;row<n;row++){
            for(int col=row;col<n;col++){
                int store=matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=store;
            }
        }
        for(int i=0;i<n;i++){
            reverse(matrix[i]);
        }
        

    }
}