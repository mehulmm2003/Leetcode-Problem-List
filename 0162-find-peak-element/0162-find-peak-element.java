class Solution {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        else if(nums[0]>nums[1]){
            return 0;

        }
        else if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        int st = 0;
        int end = nums.length - 1;
        while (st <= end) {
            int mid = (st + end) / 2;
            if (mid == st) {
                if (nums[mid] > nums[mid + 1]) {
                    return st;
                } else {
                    st = mid + 1;
                }
            } else if (mid == end) {
                if (nums[mid] > nums[mid - 1]) {
                    return end;
                } else {
                    end = mid - 1;
                }
            } else if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if(nums[mid]>nums[mid-1]) {
                st = mid + 1;
            }
            else{
                end=mid-1;
            }
        }
        return -1;
    }
}