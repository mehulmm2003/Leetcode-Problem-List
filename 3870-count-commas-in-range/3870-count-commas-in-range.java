class Solution {
    public int countCommas(int n) {
        int ncopy = n;
        int count = 0;
        int ans = 0;
        while (ncopy > 0) {
            ncopy = ncopy / 10;
            count++;
            if(count==3&&ncopy==0){
               break;
            }
            if (count == 3) {
                ans++;
                count = 0;
            }
        }
        
        if(n>999){
           ans*= (n-999);
            return ans;
        }
        else 
        {
           return ans;
        }


    }
}