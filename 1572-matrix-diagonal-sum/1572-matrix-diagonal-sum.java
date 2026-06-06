class Solution {
    public int diagonalSum(int[][] mat) {
        int n=mat.length;
        int sum=0;
        int row=0;
        int col=mat.length-1;


        for(int i=0;i<n;i++){
            sum+=mat[row][row]+mat[row][col];
            row++;
            col--;
      }
      if((mat.length)%2!=0){
        int mid=mat.length/2;
        sum-=mat[mid][mid];
      }
        return sum;
        
    }
}