class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = first(nums, target);
        ans[1] = last(nums, target);
        return ans;
    }

    public int first(int nums[], int target) {
        int res=-1;
        int st=0;
        int end=nums.length-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(nums[mid]==target){
                res=mid;
                end=mid-1;
            }
            else if(nums[mid]>target){
                end=mid-1;

            }
            else{
                st=mid+1;
            }
        }
        return res;

    }

    public int last(int nums[], int target) {
         int res=-1;
        int st=0;
        int end=nums.length-1;
        while(st<=end){
            int mid=(st+end)/2;
            if(nums[mid]==target){
                res=mid;
                st=mid+1;
            }
            else if(nums[mid]>target){
                end=mid-1;

            }
            else{
                st=mid+1;
            }
        }
        return res;

    }
}