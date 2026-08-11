class Solution {
    public int missingInteger(int[] nums) {
        if(nums.length==1){
            return  nums[0]+1;
        }
        
        int n=nums.length;
        int sum=nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]==nums[i-1]+1){
                sum+=nums[i];
            }else{
                break;
            }

        }

        for(int i=sum;;i++){
            boolean flag=true;
            for(int num:nums){
                if(i==num){
                    flag=false;
                }
            }
            if(flag==true){
                return i;
            }
        }
        
    }
}