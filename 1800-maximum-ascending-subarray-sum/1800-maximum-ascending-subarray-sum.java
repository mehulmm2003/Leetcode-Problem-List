class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum = 0;
        int st = 0;
        int end = 1;
        int temp = nums[st];
        int max = 0;
        if (nums.length == 1) {
            return temp;
        }

        while (st < end && end < nums.length) {
            if (nums[st] < nums[end]) {
                temp += nums[end];

                st++;
                end++;
            } else {
                if (max < temp) {
                    max = temp;
                    
                }
                temp = 0;
                st=end;
                end++;
                if (st < nums.length) {
                    temp = nums[st];
                }

            }

        }
        if (max < temp) {
            max = temp;
        }
        return max;

    }
}