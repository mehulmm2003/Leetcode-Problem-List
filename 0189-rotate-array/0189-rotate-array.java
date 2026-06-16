class Solution {
    public void rotate(int[] nums, int k) {
        int end=nums.length;
        k=k%end;
        reverse(nums,0,end-1);
        reverse(nums,0,k-1);
        reverse(nums,k,end-1);

    }

    public void reverse(int[] nums, int st, int end) {
        while (st < end) {
            int store = nums[st];
            nums[st] = nums[end];
            nums[end] = store;

            st++;
            end--;
        }
    }
}